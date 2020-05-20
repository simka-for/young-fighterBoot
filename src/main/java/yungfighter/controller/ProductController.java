package yungfighter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yungfighter.entity.Product;
import yungfighter.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    private List<Product> findAll(){

        return productService.findAll();
    }

    @GetMapping("{id}")
    private Product getOne(@PathVariable("id") Product product){

        return productService.getOne(product);
    }

    @PostMapping
//    @PreAuthorize("hasAuthority('ADMIN')")
    private Product create(
            @RequestBody Product product){

        return productService.create(product);
    }

    @PutMapping("{id}")
//    @PreAuthorize("hasAuthority('ADMIN')")
    private Product update(
            @PathVariable("id") Product productFromDB,
            @RequestBody Product product){

        return productService.update(productFromDB, product);

    }

    @DeleteMapping("{id}")
//    @PreAuthorize("hasAuthority('ADMIN')")
    private void delete(@PathVariable("id") Product product){

        productService.delete(product);

    }



}
