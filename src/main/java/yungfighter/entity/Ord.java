package yungfighter.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "ord")
public class Ord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "ord", cascade = CascadeType.ALL)
    private Set<ProductList> products;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    private String address;

    @Column(name = "general_price")
    private Integer generalPrice;


}
