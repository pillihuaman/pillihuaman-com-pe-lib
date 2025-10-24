package pillihuaman.com.pe.lib.security;

import java.util.List;

public interface RouteDefinitionProvider {
    List<RoutePermissionMapping> getRoutePermissionMappings();
}