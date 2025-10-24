package pillihuaman.com.pe.lib.security;

import pillihuaman.com.pe.lib.common.MyJsonWebToken;

public interface TokenParser {
    MyJsonWebToken parseToken(String authorizationHeader);
}