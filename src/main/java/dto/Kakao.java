package dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Kakao {

    private long id;
    private String email;
    private String nickname;

}