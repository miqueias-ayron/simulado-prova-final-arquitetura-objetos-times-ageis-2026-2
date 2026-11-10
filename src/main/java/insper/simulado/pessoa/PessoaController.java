package insper.simulado.pessoa;
import jakarta.validation.Valid; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController public class PessoaController {
    @Autowired private PessoaService pessoaService;
    @GetMapping("/pessoas") public List<Pessoa> list() { return pessoaService.list(); } @GetMapping("/pessoas/{id}") public Pessoa get(@PathVariable int id) { return pessoaService.getById(id); }
    @PostMapping("/pessoas") public Pessoa save(@Valid @RequestBody Pessoa pessoa) { return pessoaService.salvar(pessoa); } @PutMapping("/pessoas/{id}") public Pessoa update(@PathVariable int id, @Valid @RequestBody Pessoa pessoa) { return pessoaService.atualizar(id, pessoa); } @DeleteMapping("/pessoas/{id}") public void delete(@PathVariable int id) { pessoaService.remover(id); }
    @PostMapping("/pessoas/{idPessoa}/projetos/{idProjeto}") public Pessoa addProject(@PathVariable int idPessoa, @PathVariable int idProjeto) { return pessoaService.adicionaPessoaProjeto(idPessoa, idProjeto); }
    @DeleteMapping("/pessoas/{idPessoa}/projetos/{idProjeto}") public Pessoa removeProject(@PathVariable int idPessoa, @PathVariable int idProjeto) { return pessoaService.removePessoaProjeto(idPessoa, idProjeto); }
}
