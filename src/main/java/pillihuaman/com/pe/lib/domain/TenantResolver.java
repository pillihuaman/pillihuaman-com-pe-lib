package pillihuaman.com.pe.lib.domain;

public interface TenantResolver {
    Tenant resolveByHost(String host);
}