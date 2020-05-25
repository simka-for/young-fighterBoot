package yungfighter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yungfighter.dto.UserDto;
import yungfighter.entity.Product;
import yungfighter.entity.User;
import yungfighter.service.ProductService;
import yungfighter.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/admin/")
@CrossOrigin
public class AdminController {

    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public AdminController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping(value = "user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Integer id){
        User user = userService.findById(id);

        if (user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        UserDto result = UserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "products")
    private List<Product> findAll(){

        return productService.findAll();
    }

    @GetMapping(value = "products/{id}")
    private Product getOne(@PathVariable("id") Product product){

        return productService.getOne(product);
    }

    @PostMapping(value = "products")
    private Product create(
            @RequestBody Product product){

        return productService.create(product);
    }

    @PutMapping("products/{id}")
    private Product update(
            @PathVariable("id") Product productFromDB,
            @RequestBody Product product){

        return productService.update(productFromDB, product);

    }

    @DeleteMapping("products/{id}")
    private void delete(@PathVariable("id") Product product){

        productService.delete(product);

    }
}
