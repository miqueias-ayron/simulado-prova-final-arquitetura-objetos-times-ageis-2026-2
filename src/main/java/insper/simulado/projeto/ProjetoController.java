package insper.simulado.projeto;
import jakarta.validation.Valid; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController public class ProjetoController {
    @Autowired private ProjetoService projetoService;
    @GetMapping("/projetos") public List<Projeto> list() { return projetoService.list(); } @GetMapping("/projetos/{id}") public Projeto get(@PathVariable int id) { return projetoService.getById(id); }
    @PostMapping("/projetos") public Projeto save(@Valid @RequestBody Projeto projeto) { return projetoService.salvar(projeto); } @PutMapping("/projetos/{id}") public Projeto update(@PathVariable int id, @Valid @RequestBody Projeto projeto) { return projetoService.atualizar(id, projeto); } @DeleteMapping("/projetos/{id}") public void delete(@PathVariable int id) { projetoService.remover(id); }
}
