package br.com.Idespair.dao;

import br.com.Idespair.domain.Carro;
import br.com.Idespair.domain.Marca;

import java.util.List;

public interface ICarroDao {

    public Carro cadastrar(Carro carro);

    public void excluir (Carro carroDelete);

    public List<Carro> listarCarros();

    Carro buscarPorMarca(Marca marca);

}
