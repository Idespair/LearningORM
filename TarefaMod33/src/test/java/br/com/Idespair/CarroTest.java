package br.com.Idespair;

import br.com.Idespair.dao.*;
import br.com.Idespair.domain.Acessorio;
import br.com.Idespair.domain.Carro;
import br.com.Idespair.domain.Marca;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CarroTest {

    private ICarroDao carroDao;
    private IMarcaDao marcaDao;
    private IAcessorioDao acessorioDao;

    public CarroTest() {
        carroDao = new CarroDao();
        acessorioDao = new AcessorioDao();
        marcaDao = new MarcaDao();
    }

    @Test
    public void cadastrar(){
        Marca marca = criarMarca("TYT");
        Acessorio acessorio = criarAcessorio("A1");

        Carro carro = new Carro();
        carro.setAno(2021);
        carro.setModelo("Corolla");
        carro.setPreço(149000d);
        carro.setMarca(marca);
        carro.setAcessorio(acessorio);

        Carro carro2 = new Carro();
        carro2.setAno(1997);
        carro2.setModelo("Supra");
        carro2.setPreço(1400000d);
        carro2.setMarca(marca);
        carro2.setAcessorio(acessorio);

        carro = carroDao.cadastrar(carro);
        carro2 = carroDao.cadastrar(carro2);
        assertNotNull(carro);
        assertNotNull(carro2);
    }

    private Marca criarMarca(String codigo){
        Marca marca = new Marca();

        marca.setCodigo(codigo);
        marca.setNome("Toyota");
        marca.setNacionalidade("Japan");
        return marcaDao.cadastrar(marca);
    }

    private Acessorio criarAcessorio(String codigo){
        Acessorio acessorio = new Acessorio();

        acessorio.setCodigo(codigo);
        acessorio.setFabricante("Wiltec");
        acessorio.setComponente("Pastilha");
        return acessorioDao.cadastrar(acessorio);
    }

}
