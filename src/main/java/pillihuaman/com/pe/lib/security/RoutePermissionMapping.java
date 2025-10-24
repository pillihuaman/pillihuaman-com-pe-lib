package pillihuaman.com.pe.lib.security;
import org.springframework.http.HttpMethod;


import org.springframework.http.HttpMethod;

public class RoutePermissionMapping {
    private String antPattern;
    private HttpMethod httpMethod;
    private String requiredPermission;
    public RoutePermissionMapping(String antPattern, HttpMethod httpMethod, String requiredPermission) {
        this.antPattern = antPattern;
        this.httpMethod = httpMethod;
        this.requiredPermission = requiredPermission;
    }

    public String getAntPattern() {
        return antPattern;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public String getRequiredPermission() {
        return requiredPermission;
    }
}
