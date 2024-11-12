package apitestime.example.demo.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter

public class LoginResponse {
    private String email;
    private String token;

   public  LoginResponse(String email , String token){
        this.email= email;
        this.token = token;
    }


}
