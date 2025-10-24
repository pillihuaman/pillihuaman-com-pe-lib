package pillihuaman.com.pe.lib.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import java.util.List;
import java.util.Optional;

@Service
public class RoutePermissionService {

    @Autowired private RouteDefinitionProvider routeDefinitionProvider;
    private final AntPathMatcher pathMatcher = new AntPathMatcher();

//@Cacheable("routePermissions")
    public List<RoutePermissionMapping> getCachedMappings() {
        return routeDefinitionProvider.getRoutePermissionMappings();
    }

    public Optional<String> getRequiredPermission(String requestPath, HttpMethod requestMethod) {
        return getCachedMappings().stream()
                .filter(mapping -> requestMethod.equals(mapping.getHttpMethod()) && pathMatcher.match(mapping.getAntPattern(), requestPath))
                .map(RoutePermissionMapping::getRequiredPermission)
                .findFirst();
    }
}