package insper.simulado.departamento;
import jakarta.validation.Valid; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController public class DepartamentoController {
    @Autowired private DepartamentoService departamentoService;
    @GetMapping("/departamentos") public List<Departamento> list() { return departamentoService.list(); }
    @GetMapping("/departamentos/{id}") public Departamento get(@PathVariable int id) { return departamentoService.getById(id); }
    @PostMapping("/departamentos") public Departamento save(@Valid @RequestBody Departamento departamento) { return departamentoService.salvar(departamento); }
    @PutMapping("/departamentos/{id}") public Departamento update(@PathVariable int id, @Valid @RequestBody Departamento departamento) { return departamentoService.atualizar(id, departamento); }
    @DeleteMapping("/departamentos/{id}") public void delete(@PathVariable int id) { departamentoService.remover(id); }
}
