package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dto.Product;
import jakarta.persistence.*;
import lombok.*;



@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productDetail")
public class ProductDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "prodNo", referencedColumnName = "prodNo")
    private Product product;
    private String size;
    private Long amount;

}