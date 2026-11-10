package insper.simulado.pessoa;
import insper.simulado.projeto.Projeto; import insper.simulado.projeto.ProjetoService; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Service; import java.util.List;
@Service public class PessoaService {
    @Autowired private PessoaRepository pessoaRepository; @Autowired private ProjetoService projetoService;
    public Pessoa salvar(Pessoa pessoa) { return pessoaRepository.save(pessoa); } public List<Pessoa> list() { return pessoaRepository.findAll(); }
    public Pessoa getById(int id) { return pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada")); }
    public Pessoa atualizar(int id, Pessoa pessoa) { Pessoa atual = getById(id); atual.setNome(pessoa.getNome()); atual.setCpf(pessoa.getCpf()); return pessoaRepository.save(atual); }
    public void remover(int id) { pessoaRepository.delete(getById(id)); }
    public Pessoa adicionaPessoaProjeto(int idPessoa, int idProjeto) { Pessoa pessoa = getById(idPessoa); Projeto projeto = projetoService.getById(idProjeto); if (!pessoa.getProjetos().contains(projeto)) pessoa.getProjetos().add(projeto); if (!projeto.getPessoas().contains(pessoa)) projeto.getPessoas().add(pessoa); return pessoaRepository.save(pessoa); }
    public Pessoa removePessoaProjeto(int idPessoa, int idProjeto) { Pessoa pessoa = getById(idPessoa); Projeto projeto = projetoService.getById(idProjeto); pessoa.getProjetos().remove(projeto); projeto.getPessoas().remove(pessoa); return pessoaRepository.save(pessoa); }
}
