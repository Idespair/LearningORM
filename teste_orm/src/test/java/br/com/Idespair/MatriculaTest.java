package br.com.Idespair;

import br.com.Idespair.dao.*;
import br.com.Idespair.domain.Aluno;
import br.com.Idespair.domain.Computador;
import br.com.Idespair.domain.Curso;
import br.com.Idespair.domain.Matricula;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.assertNotNull;

public class MatriculaTest {

    private IMatriculaDao matriculaDao;
    private ICursoDao cursoDao;
    private IAlunoDao alunoDao;
    private IComputadorDao computadorDao;

    public MatriculaTest() {
        matriculaDao = new MatriculaDao();
        cursoDao = new CursoDao();
        alunoDao = new AlunoDao();
        computadorDao = new ComputadorDao();
    }

    @Test
    public void cadastrar() {
        Curso curso = criarCurso("A1");
        Aluno aluno = criarAluno("A1");

        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("Ativa");
        mat.setValor(2000d);
        mat.setCurso(curso);
        mat.setAluno(aluno);

        aluno.setMatricula(mat);
        mat = matriculaDao.cadastrar(mat);

        assertNotNull(mat);
        assertNotNull(mat.getId());
    }

    private Computador criarComputador(String codigo) {
        Computador computador = new Computador();
        computador.setCodigo(codigo);
        computador.setDescricao("Computador 1");
        return computador;
        //return computadorDao.cadastrar(computador);
    }

    private Aluno criarAluno(String codigo) {
        Computador comp = criarComputador("A1");
        Computador comp2 = criarComputador("A2");
        Aluno aluno = new Aluno();
        aluno.setCodigo(codigo);
        aluno.setNome("Rodrigo");
        aluno.add(comp);
        aluno.add(comp2);
        //comp.add(aluno);
        //comp2.add(aluno);
        return alunoDao.cadastrar(aluno);
    }

    private Curso criarCurso(String codigo) {
        Curso curso = new Curso();
        curso.setCodigo(codigo);
        curso.setDescricao("CURSO TESTE");
        curso.setNome("CURSO JAVA");
        return cursoDao.cadastrar(curso);
    }

}
