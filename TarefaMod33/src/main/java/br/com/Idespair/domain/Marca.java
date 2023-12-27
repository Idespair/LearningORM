package br.com.Idespair.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_MARCA")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marca_seq")
    @SequenceGenerator(name = "marca_seq", sequenceName = "sq_marca", initialValue = 1, allocationSize = 1)
    int id_marca;
    @Column(name = "NOME", length = 20, nullable = false)
    String nome;

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    @Column(name = "CODIGO", length = 20, nullable = false)
    String codigo;
    @Column(name = "NACIONALIDADE", length = 20, nullable = false)
    String nacionalidade;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_marca_fk", referencedColumnName = "id_marca")
    private List<Carro> carros;

    public int getId() {
        return id_marca;
    }

    public void setId(int id) {
        this.id_marca = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}
