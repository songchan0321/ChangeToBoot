package dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {
    private Long idx;
    private Long prodNo;
    private Long size;
    private Long amount;
}