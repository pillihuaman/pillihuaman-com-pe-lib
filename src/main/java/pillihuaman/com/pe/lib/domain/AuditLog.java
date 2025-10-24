package pillihuaman.com.pe.lib.domain;


import lombok.Builder;
import lombok.Data;
import pillihuaman.com.pe.lib.common.AuditEntity;

import java.time.Instant;
import java.util.UUID;


@Data
@Builder
public class AuditLog {

    private UUID id;

    /**
     * El ID de la entidad que fue modificada.
     */
    private String entityId;

    /**
     * El nombre de la entidad/agregado. Ej: "Product", "SalesOrder".
     */
    private String entityName;

    /**
     * La acción realizada. Ej: "CREATE", "UPDATE", "DELETE".
     */
    private String action;

    /**
     * El nombre del campo que cambió. Ej: "pricing.sellingPrice".
     */
    private String fieldName;

    /**
     * Un fragmento del documento ANTES del cambio, representado como un objeto genérico (Map).
     * Esto permite guardar contexto, como el objeto 'pricing' completo.
     */
    private Object oldValueContext;

    /**
     * Un fragmento del documento DESPUÉS del cambio.
     */
    private Object newValueContext;

    /**
     * Información del usuario que realizó la acción.
     */
    private AuditEntity auditEntity;

    /**
     * La marca de tiempo de cuándo ocurrió el evento.
     */
    private Instant timestamp;
}