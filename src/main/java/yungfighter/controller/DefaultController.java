package yungfighter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yungfighter.dto.ProductDto;
import yungfighter.entity.Product;
import yungfighter.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class DefaultController {

    private final ProductService productService;

    public DefaultController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll() {

        List<Product> all = productService.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();

        if (all == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        for (Product product : all) {
            ProductDto productDto = ProductDto.fromProduct(product);
            productDtoList.add(productDto);
        }
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }
}
