package insper.simulado.departamento;
import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Service; import java.util.List;
@Service public class DepartamentoService {
    @Autowired private DepartamentoRepository departamentoRepository;
    public Departamento salvar(Departamento departamento) { return departamentoRepository.save(departamento); }
    public List<Departamento> list() { return departamentoRepository.findAll(); }
    public Departamento getById(int id) { return departamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Departamento não encontrado")); }
    public Departamento atualizar(int id, Departamento departamento) { Departamento atual = getById(id); atual.setNome(departamento.getNome()); return departamentoRepository.save(atual); }
    public void remover(int id) { departamentoRepository.delete(getById(id)); }
}
