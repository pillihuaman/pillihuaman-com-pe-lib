package pillihuaman.com.pe.lib.domain;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class TenantInterceptor implements HandlerInterceptor {

    private final TenantResolver resolver;

    public TenantInterceptor(TenantResolver resolver) {
        this.resolver = resolver;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String host = request.getHeader("Host");
        if (host != null) {
            Tenant tenant = resolver.resolveByHost(host.toLowerCase());
            if (tenant != null && tenant.isActive()) {
                TenantContext.setTenant(tenant);
                return true;
            }
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        TenantContext.clear();
    }
}