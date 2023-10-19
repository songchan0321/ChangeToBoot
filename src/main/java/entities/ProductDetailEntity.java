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
    //joincolumn시 prodNo 생성
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "prodNo", referencedColumnName = "prodNo")
    private Product product; // 외래 키를 참조하는 관계 설정
    private String size;
    private Long amount;

}