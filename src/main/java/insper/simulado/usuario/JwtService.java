package insper.simulado.usuario;
import io.jsonwebtoken.Jwts; import io.jsonwebtoken.SignatureAlgorithm; import io.jsonwebtoken.io.Decoders; import io.jsonwebtoken.security.Keys; import org.springframework.beans.factory.annotation.Value; import org.springframework.stereotype.Service; import javax.crypto.SecretKey; import java.util.Base64; import java.util.Date;
@Service public class JwtService {
    @Value("${jwt.secret}") private String secretKey; @Value("${jwt.expiration:3600000}") private long jwtExpiration;
    public String generateToken(String email) { return Jwts.builder().subject(email).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis() + jwtExpiration)).signWith(getSigningKey(), SignatureAlgorithm.HS256).compact(); }
    public String extractUsername(String token) { return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload().getSubject(); }
    public boolean isTokenValid(String token) { try { Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token); return true; } catch (Exception e) { return false; } }
    private SecretKey getSigningKey() { byte[] keyBytes = Decoders.BASE64.decode(Base64.getEncoder().encodeToString(secretKey.getBytes())); return Keys.hmacShaKeyFor(keyBytes); }
}
