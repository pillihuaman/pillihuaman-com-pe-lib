package pillihuaman.com.pe.lib.common;

import java.util.UUID;

public class ResponseUtil {

    public static <T> RespBase<T> buildSuccessResponse(T payload) {
        RespBase<T> resp = new RespBase<>();
        resp.setPayload(payload);
        resp.getStatus().setSuccess(true);
        resp.getStatus().setError(null); // Sin errores en respuesta exitosa
        resp.setTrace(new RespBase.Trace(UUID.randomUUID().toString()));
        return resp;
    }
}
