package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "curso", schema = "public")
public class Curso {

    @Id
    private Long codigo;
    private String nome;
    private int cargaHoraria;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CURSO_ALUNO", joinColumns = {@JoinColumn(name = "CURSO_CODIGO")}, inverseJoinColumns = {@JoinColumn(name = "ALUNO_MATRICULA")})
    private List<Aluno> alunos;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
