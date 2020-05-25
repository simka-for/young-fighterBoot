package yungfighter.dto;

import lombok.Data;
import yungfighter.entity.Product;

@Data
public class ProductDto {

    private Integer id;
    private String name;
    private String description;
    private Integer price;

    public Product toProduct(){
        Product product = new Product();

        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);

        return product;
    }

    public static ProductDto fromProduct(Product product){
        ProductDto productDto = new ProductDto();

        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());

        return productDto;
    }
}
