package yungfighter.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yungfighter.entity.Product;
import yungfighter.repository.ProductRepository;
import yungfighter.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {

        return productRepository.findAll();
    }

    @Override
    public Product getOne(Product product) {

        return productRepository.getOne(product.getId());
    }

    @Override
    public Product create(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Product update(Product productFromDb, Product product) {

        BeanUtils.copyProperties(product, productFromDb, "id");

        return productRepository.save(productFromDb);
    }

    @Override
    public void delete(Product product) {

        productRepository.delete(product);
    }
}
