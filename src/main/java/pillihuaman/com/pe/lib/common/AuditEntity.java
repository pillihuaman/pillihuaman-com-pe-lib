package pillihuaman.com.pe.lib.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@Setter
@Getter
public class AuditEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @BsonProperty(value = "_id")
    private ObjectId id;
    private ObjectId codUser;
    private ObjectId codCompany;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX")
    private Date dateRegister;
    private ObjectId codUserUpdate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSXXX")
    private Date dateUpdate;
    private String mail;
    private String mailUpdate;
    private String sourceIpAddress;
    private String userAgent;
    private String deviceType;
    private GeoLocation geoLocation;

    private String browserName;
    private String browserVersion;
    private String osName;
    private String osVersion;
    private String screenResolution;
    private String language;
    private String platform;
    private String timeZone;

    private String networkType;
    private Double connectionDownlink;
    private Double connectionRtt;
    private Boolean vpnDetected;

    private String deviceId;
    private String sessionId;
    private String authMethod;

    private String lastVisitedPage;
    private List<String> clickPath;
    private Long idleTime;


    public AuditEntity() {}
}

