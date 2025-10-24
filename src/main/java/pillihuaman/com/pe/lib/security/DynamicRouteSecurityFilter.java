
package pillihuaman.com.pe.lib.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pillihuaman.com.pe.lib.common.MyJsonWebToken;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class DynamicRouteSecurityFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(DynamicRouteSecurityFilter.class);

    @Autowired private TokenParser tokenParser;
    @Autowired private RoutePermissionService routePermissionService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        final String path = request.getRequestURI();

        // Si la ruta es para comunicación interna entre servicios, se salta la
        // validación de permisos de usuario. Se asume que el JwtAuthenticationFilter
        // ya validó que la petición viene de un servicio autenticado.
        if (path.startsWith("/internal/")) {
            logger.debug("Ruta interna detectada: '{}'. Saltando chequeo de permisos de usuario.", path);
            filterChain.doFilter(request, response);
            return;
        }

        HttpMethod method = HttpMethod.valueOf(request.getMethod());

        logger.info("======================[ INICIO CHEQUEO DE PERMISOS ]======================");
        logger.info("Ruta solicitada: [{}]{}", method, path);

        Optional<String> requiredPermissionOpt = routePermissionService.getRequiredPermission(path, method);

        if (requiredPermissionOpt.isPresent()) {
            String requiredPermission = requiredPermissionOpt.get();
            logger.info("-> Permiso Requerido para la Ruta: '{}'", requiredPermission);

            String authHeader = request.getHeader("Authorization");

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                logger.warn("-> ¡ACCESO DENEGADO! Razón: Token de autenticación no proporcionado.");
                throw new AccessDeniedException("Token de autenticación no proporcionado.");
            }

            try {
                MyJsonWebToken tokenData = tokenParser.parseToken(authHeader);
                List<String> userPermissions = tokenData.getPermissions() != null ? tokenData.getPermissions() : Collections.emptyList();
                logger.info("-> Permisos del Usuario (desde el Token): {}", userPermissions);

                if (userPermissions.contains(requiredPermission)) {
                    logger.info("-> Resultado: ¡ACCESO PERMITIDO! El usuario tiene el permiso requerido.");
                } else {
                    logger.warn("-> ¡ACCESO DENEGADO! Razón: El usuario NO tiene el permiso requerido '{}'.", requiredPermission);
                    throw new AccessDeniedException("No tiene permiso para acceder a este recurso. Se requiere: " + requiredPermission);
                }
            } catch (Exception e) {
                logger.error("-> ¡ACCESO DENEGADO! Razón: Error al parsear o validar el token.", e);
                throw new AccessDeniedException("El token proporcionado no es válido o ha expirado.");
            }

        } else {
            logger.info("-> Permiso Requerido para la Ruta: NINGUNO (Ruta no protegida por este filtro).");
        }

        logger.info("======================[ FIN CHEQUEO DE PERMISOS ]======================\n");
        filterChain.doFilter(request, response);
    }
}
