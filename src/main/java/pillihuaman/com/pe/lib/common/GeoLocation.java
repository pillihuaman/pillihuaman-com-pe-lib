package pillihuaman.com.pe.lib.common;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeoLocation implements Serializable {
    private String country;
    private String city;
    private String coordinates; // "lat,lon"
}
