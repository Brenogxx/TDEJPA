package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aluno", schema = "public")
public class Aluno {

    @Id
    private Long matricula;
    private String nome;
    @ManyToMany(mappedBy = "alunos", cascade = CascadeType.ALL)
    private List<Curso> cursos;

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
