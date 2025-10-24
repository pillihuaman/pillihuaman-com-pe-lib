package pillihuaman.com.pe.lib.common;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.jboss.resteasy.jwt.JsonWebToken;


import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyJsonWebToken extends JsonWebToken implements Serializable {

    private static long serialVersionUID = 1L;


    private ResponseUser user;
    private Application aplication;
    private String tenantId;
    private List<String> permissions;
    public static class Application {

        public ObjectId getAplicationID() {
            return aplicationID;
        }

        public void setAplicationID(ObjectId aplicationID) {
            this.aplicationID = aplicationID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMultiSession() {
            return multiSession;
        }

        public void setMultiSession(String multiSession) {
            this.multiSession = multiSession;
        }

        private ObjectId aplicationID;
        private String name;
        private String multiSession;

    }


    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    /**
     * @param serialversionuid the serialversionuid to set
     */
    public static void setSerialversionuid(long serialversionuid) {
        serialVersionUID = serialversionuid;
    }


    /**
     * @param idUser the idUser to set
     */


    /**
     * @param aplicationID the aplicationID to set
     */
    public void setAplicationID(ObjectId aplicationID) {
        this.aplication.aplicationID = aplicationID;
    }


    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.aplication.name = name;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    /**
     * @param multiSession the multiSession to set
     */

    public void setMultiSession(String multiSession) {
        this.aplication.multiSession = multiSession;
    }

    public void setUser(ResponseUser user) {
        this.user = user;
    }

    public void setApplication(Application aplication) {
        this.aplication = aplication;
    }

}
