package insper.simulado.pessoa;
import com.fasterxml.jackson.annotation.JsonIgnore; import insper.simulado.projeto.Projeto; import jakarta.persistence.*; import jakarta.validation.constraints.NotEmpty; import jakarta.validation.constraints.NotNull; import java.util.ArrayList; import java.util.List;
@Entity public class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    @NotNull(message = "Nome não pode ser nulo") @NotEmpty(message = "Nome não pode ser vazio") @Column(nullable = false) private String nome;
    @NotNull(message = "CPF não pode ser nulo") @NotEmpty(message = "CPF não pode ser vazio") @Column(nullable = false, unique = true) private String cpf;
    @JsonIgnore @ManyToMany(mappedBy = "pessoas") private List<Projeto> projetos = new ArrayList<>();
    public int getId() { return id; } public void setId(int id) { this.id = id; } public String getNome() { return nome; } public void setNome(String nome) { this.nome = nome; } public String getCpf() { return cpf; } public void setCpf(String cpf) { this.cpf = cpf; } public List<Projeto> getProjetos() { return projetos; } public void setProjetos(List<Projeto> projetos) { this.projetos = projetos; }
}
