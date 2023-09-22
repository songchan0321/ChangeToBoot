package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString

public class PurchaseEntity {

    @Id
    @Column(name = "user_id", nullable = false, length = 20)
    private String id;

    @Column(name = "user_name", nullable = false, length = 10)
    private String userName;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "ssn", nullable = false, length = 50)
    private String ssn;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "pro_tran_code", nullable = false, length = 50)
    private String proTranCode;

    @Column(name = "count", nullable = false, length = 50)
    private int count;

}
