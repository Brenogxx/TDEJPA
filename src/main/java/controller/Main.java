package controller;

import model.Aluno;
import model.Curso;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TDEJPAUNIVERSIDADE");

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Curso c1 = new Curso();
            c1.setCodigo(34528L);
            c1.setNome("Sistemas de Informação");
            c1.setCargaHoraria(2000);

            Aluno a1 = new Aluno();
            a1.setMatricula(50015819L);
            a1.setNome("Breno Ximenes");

            List<Curso> cursos = new ArrayList<>();
            List<Aluno> alunos = new ArrayList<>();

            cursos.add(c1);
            alunos.add(a1);

            a1.setCursos(cursos);
            c1.setAlunos(alunos);

            em.persist(c1);
            em.persist(a1);


            em.getTransaction().commit();

            String jpql = "SELECT matricula, nome FROM Aluno";
            Query query = em.createQuery(jpql);


            List<Object[]> resultados = query.getResultList();
            List<Aluno> resultado = new ArrayList<>();


            for (Object[] result : resultados) {
                Long matricula = (Long) result[0];
                String nome = (String) result[1];


                Aluno aluno = new Aluno();
                aluno.setMatricula(matricula);
                aluno.setNome(nome);
                resultado.add(aluno);

            }

            resultado.forEach(aluno -> System.out.println("\n\nMatrícula: " + aluno.getMatricula() + ", Nome: " + aluno.getNome()));



        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();

        //

    }
}
