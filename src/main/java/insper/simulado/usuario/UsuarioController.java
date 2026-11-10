package insper.simulado.usuario;
import org.springframework.beans.factory.annotation.Autowired; import org.springframework.web.bind.annotation.*;
@RestController public class UsuarioController {
    @Autowired private UsuarioService usuarioService;
    @PostMapping("/usuarios") public User createUser(@RequestBody User user) { return usuarioService.create(user); }
    @PostMapping("/login") public LoginResponse login(@RequestBody LoginRequest loginRequest) { return usuarioService.login(loginRequest); }
}
