package br.com.Idespair.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PROD")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", sequenceName = "sq_prod", initialValue = 1, allocationSize = 1)
    Long id;
    @Column(name = "name", length = 50, nullable = false)
    String name;
    @Column(name = "manufacturer", length = 50, nullable = false)
    String manufacturer;
    @Column(name = "price", length = 4, nullable = false)
    Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
