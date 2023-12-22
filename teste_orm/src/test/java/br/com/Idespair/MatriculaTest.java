package br.com.Idespair;

import br.com.Idespair.dao.IMatriculaDao;
import br.com.Idespair.dao.MatriculaDao;
import br.com.Idespair.domain.Matricula;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.assertNotNull;

public class MatriculaTest {

    private IMatriculaDao matriculaDao;

    public MatriculaTest() {
        matriculaDao = new MatriculaDao();
    }

    @Test
    public void cadastrar () {
        Matricula mat = new Matricula();
        mat.setCodigo("A1");
        mat.setDataMatricula(Instant.now());
        mat.setStatus("Ativa");
        mat.setValor(2000d);

        mat = matriculaDao.cadastrar(mat);

        assertNotNull(mat);
        assertNotNull(mat.getId());
    }

}
