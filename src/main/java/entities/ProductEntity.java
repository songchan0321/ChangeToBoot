package entities;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString

public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prod_no")
    private Long no; //상품 코드

    @Column(name = "prod_name", nullable = false, length = 50)
    private String prodName; //상품 이름

    @Lob
    @Column(name = "prod_detail", nullable = false, length = 50)
    private String prodDetail; //상세 정보

    @Column(name = "price", nullable = false)
    private int price; //가격

    @Column(name = "file_name", nullable = true, length = 50)
    private String fileName; //파일(이미지)이름

    @Column(name = "reg_date", nullable = false)
    private Date regDate;

    @Column(name = "pro_tran_code", nullable = false, length = 50)
    private String proTranCode;

    @Column(name = "count", nullable = false, length = 50)
    private int count;

}
