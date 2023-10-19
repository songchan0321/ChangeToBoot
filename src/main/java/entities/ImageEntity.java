package entities;

import dto.Product;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;



@Builder
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "options")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name="prodNo")
    private Product product;    // addProductDto의 prodNo
    private String imgUrl;


}