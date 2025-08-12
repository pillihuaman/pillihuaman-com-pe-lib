package pillihuaman.com.pe.lib.domain;import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import pillihuaman.com.pe.lib.common.AuditEntity;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tenant")
public class Tenant implements Serializable {
    private static final long serialVersionUID = 1L;
    private ObjectId id;
    private String name;
    private String domain;

    @Getter(lombok.AccessLevel.PUBLIC)
    @Setter
    private boolean active;

    private AuditEntity audit;

    public boolean isActive() {
        return active;
    }
}
