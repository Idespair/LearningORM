package br.com.Idespair.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio_seq")
    @SequenceGenerator(name = "acessorio_seq", sequenceName = "sq_acessorio", initialValue = 1, allocationSize = 1)
    int id_aces;
    @Column(name = "COMPONENTE", length = 25, nullable = false)
    String componente;
    @Column(name = "FABRICANTE", length = 25, nullable = false)
    String fabricante;
    @Column(name = "CODIGO", length = 20, nullable = false)
    String codigo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_acessorio_fk", referencedColumnName = "id_aces")
    private List<Carro> carros;

    public int getId_aces() {
        return id_aces;
    }

    public void setId_aces(int id_aces) {
        this.id_aces = id_aces;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId() {
        return id_aces;
    }

    public void setId(int id) {
        this.id_aces = id;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}
