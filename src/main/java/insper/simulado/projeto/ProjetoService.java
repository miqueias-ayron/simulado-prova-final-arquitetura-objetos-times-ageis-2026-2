package insper.simulado.projeto;
import insper.simulado.departamento.Departamento; import insper.simulado.departamento.DepartamentoService; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Service; import java.util.List;
@Service public class ProjetoService {
    @Autowired private ProjetoRepository projetoRepository; @Autowired private DepartamentoService departamentoService;
    public Projeto salvar(Projeto projeto) { Departamento departamento = departamentoService.getById(projeto.getDepartamento().getId()); projeto.setDepartamento(departamento); return projetoRepository.save(projeto); }
    public List<Projeto> list() { return projetoRepository.findAll(); } public Projeto getById(int id) { return projetoRepository.findById(id).orElseThrow(() -> new RuntimeException("Projeto não encontrado")); }
    public Projeto atualizar(int id, Projeto projeto) { Projeto atual = getById(id); atual.setNome(projeto.getNome()); atual.setDescricao(projeto.getDescricao()); atual.setDepartamento(departamentoService.getById(projeto.getDepartamento().getId())); return projetoRepository.save(atual); }
    public void remover(int id) { projetoRepository.delete(getById(id)); }
}
