package pillihuaman.com.pe.lib.security;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pillihuaman.com.pe.lib.common.MyJsonWebToken;

import java.util.List;

@Service
@Primary
public class TokenParserImpl implements TokenParser {

    @Override
    public MyJsonWebToken parseToken(String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        // Lógica para decodificar o validar el JWT
        MyJsonWebToken jwt = new MyJsonWebToken();
        jwt.setPermissions(List.of("USER_VIEW", "ORDER_CREATE")); // Ejemplo
        return jwt;
    }
}
