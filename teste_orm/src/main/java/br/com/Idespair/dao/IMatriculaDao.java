package br.com.Idespair.dao;

import br.com.Idespair.domain.Curso;
import br.com.Idespair.domain.Matricula;

import java.util.List;

public interface IMatriculaDao {

    Matricula cadastrar (Matricula mat);

    void excluir (Matricula matric);

    List<Matricula> buscarTodos();

    Matricula buscarPorCodigoCursoCriteria(String codigoCurso);

    Matricula buscarPorCursoCriteria(Curso curso);

}
