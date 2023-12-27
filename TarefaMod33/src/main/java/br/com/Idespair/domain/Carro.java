package br.com.Idespair.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_CARRO")
public class Carro{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
    @SequenceGenerator(name = "carro_seq", sequenceName = "sq_carro", initialValue = 1, allocationSize = 1)
    int id_carro;
    @Column(name = "MODELO", length = 25, nullable = false)
    String modelo;
    @Column(name = "ANO", length = 4, nullable = false)
    int ano;
    @Column(name = "PRECO", length = 6, nullable = false)
    Double preço;
    @ManyToOne
    @JoinColumn(name = "id_marca_fk",
            foreignKey = @ForeignKey(name = "fk_carro_marca"),
            referencedColumnName = "id_marca", nullable = false)
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "id_acessorio_fk",
            foreignKey = @ForeignKey(name = "fk_carro_acessorio"),
            referencedColumnName = "id_aces", nullable = false)
    private Acessorio acessorio;
    public String getModelo() {
        return modelo;
    }

    public int getId_carro() {
        return id_carro;
    }

    public void setId_carro(int id_carro) {
        this.id_carro = id_carro;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Double getPreço() {
        return preço;
    }

    public void setPreço(Double preço) {
        this.preço = preço;
    }

    public Acessorio getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }
}

