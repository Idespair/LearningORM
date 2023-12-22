package br.com.Idespair;

import br.com.Idespair.dao.CursoDao;
import br.com.Idespair.dao.ICursoDao;
import br.com.Idespair.domain.Curso;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CursoTest {

    private ICursoDao cursoDao;

    public CursoTest(){
        cursoDao = new CursoDao();
    }

    @Test
    public void cadastrar() {
        Curso curso = new Curso();
        curso.setCodigo("A1");
        curso.setDescricao("CURSO TESTE");
        curso.setNome("CURSO JAVA");
        curso = cursoDao.cadastrar(curso);

        assertNotNull(curso);
        assertNotNull(curso.getId());
    }

}
