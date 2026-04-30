package pe.joedayz.dfc.security.web;

import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.joedayz.dfc.security.jwt.JwtIssuer;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final JwtIssuer jwtIssuer;

  public AuthController(JwtIssuer jwtIssuer) {
    this.jwtIssuer = jwtIssuer;
  }

  @PostMapping("/login")
  public TokenResponse login(@RequestBody LoginRequest body) {
    if (!"demo".equals(body.user()) || !"demo".equals(body.password())) {
      throw new IllegalArgumentException("Credenciales inválidas (usa demo/demo)");
    }
    return new TokenResponse(jwtIssuer.createToken(body.user()));
  }

  public record LoginRequest(@NotBlank String user, @NotBlank String password) {}

  public record TokenResponse(String accessToken) {}
}
