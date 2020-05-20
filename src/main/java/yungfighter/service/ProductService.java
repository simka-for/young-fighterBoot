package yungfighter.service;


import yungfighter.entity.Product;

import java.util.List;


public interface ProductService {

    List<Product> findAll();
    Product getOne(Product product);
    Product create(Product product);
    Product update(Product productFromDb, Product product);
    void delete(Product product);


}
