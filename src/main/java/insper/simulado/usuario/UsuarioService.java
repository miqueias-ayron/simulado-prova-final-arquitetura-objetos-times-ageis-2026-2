package insper.simulado.usuario;
import org.springframework.beans.factory.annotation.Autowired; import org.springframework.security.core.userdetails.UserDetails; import org.springframework.security.core.userdetails.UserDetailsService; import org.springframework.security.core.userdetails.UsernameNotFoundException; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.stereotype.Service;
@Service public class UsuarioService implements UserDetailsService {
    @Autowired private UsuarioRepository usuarioRepository; @Autowired private PasswordEncoder passwordEncoder; @Autowired private JwtService jwtService;
    public User create(User user) { user.setSenha(passwordEncoder.encode(user.getSenha())); return usuarioRepository.save(user); }
    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { User user = usuarioRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado")); return org.springframework.security.core.userdetails.User.builder().username(user.getEmail()).password(user.getSenha()).build(); }
    public LoginResponse login(LoginRequest loginRequest) { UserDetails userDetails = loadUserByUsername(loginRequest.getEmail()); if (!passwordEncoder.matches(loginRequest.getSenha(), userDetails.getPassword())) throw new RuntimeException("Senha inválida"); return new LoginResponse(jwtService.generateToken(loginRequest.getEmail())); }
}
