package yungfighter.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    private String name;

    private String description;

    private Integer price;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_list_id")
//    private ProductList productList;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductList> productList;

}
