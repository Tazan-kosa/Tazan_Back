package ion.kosa.TazanBack.config.jwt;

public interface JwtProperties {
    String SECRET = "TaZan";
    int EXPIRATION_TIME=1000000000;//1000 = 1초 10000 = 10초 60000 = 1분 *10 = 10분
    String TOKEN_PREFIX="Bearer ";
    String HEADER_STRING="Authorization";
}
