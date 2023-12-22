package br.com.Idespair.dao;

import br.com.Idespair.domain.Product;

import java.util.List;

public interface IProductDao {

    public Product register(Product prod);

    public void delete(Product prodDelete);

    public List<Product> list();

}
