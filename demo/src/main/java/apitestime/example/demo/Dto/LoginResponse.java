package apitestime.example.demo.Dto;


import lombok.AllArgsConstructor;


public class LoginResponse {
    private String email;
    private String token;

   public  LoginResponse(String email , String token){
        this.email= email;
        this.token = token;
    }


}
