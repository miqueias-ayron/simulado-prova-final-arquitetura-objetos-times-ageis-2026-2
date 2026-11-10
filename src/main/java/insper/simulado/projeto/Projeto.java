package insper.simulado.projeto;
import com.fasterxml.jackson.annotation.JsonIgnore; import insper.simulado.departamento.Departamento; import insper.simulado.pessoa.Pessoa; import jakarta.persistence.*; import jakarta.validation.constraints.NotEmpty; import jakarta.validation.constraints.NotNull; import java.util.ArrayList; import java.util.List;
@Entity public class Projeto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    @NotNull(message = "Nome não pode ser nulo") @NotEmpty(message = "Nome não pode ser vazio") @Column(nullable = false) private String nome;
    private String descricao;
    @ManyToOne @JoinColumn(name = "id_departamento", nullable = false) private Departamento departamento;
    @JsonIgnore @ManyToMany @JoinTable(name = "projeto_pessoa", joinColumns = @JoinColumn(name = "id_projeto"), inverseJoinColumns = @JoinColumn(name = "id_pessoa")) private List<Pessoa> pessoas = new ArrayList<>();
    public int getId() { return id; } public void setId(int id) { this.id = id; } public String getNome() { return nome; } public void setNome(String nome) { this.nome = nome; } public String getDescricao() { return descricao; } public void setDescricao(String descricao) { this.descricao = descricao; } public Departamento getDepartamento() { return departamento; } public void setDepartamento(Departamento departamento) { this.departamento = departamento; } public List<Pessoa> getPessoas() { return pessoas; } public void setPessoas(List<Pessoa> pessoas) { this.pessoas = pessoas; }
}
