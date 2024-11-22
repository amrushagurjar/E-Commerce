package apitestime.example.demo.controller;

import apitestime.example.demo.Dto.LoginResponse;
import apitestime.example.demo.Dto.UserDto;
import apitestime.example.demo.config.JwtHelper;
import apitestime.example.demo.service.LoginService;
import apitestime.example.demo.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    // private final KafkaProducer kafkaProducer;
    private final SignUpService signUpService;
    // private LoginResponse LoginResponse;


    private final LoginService loginService;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/signUp")
    public ResponseEntity<Void> signUp(@RequestBody UserDto userDto) {
        this.signUpService.addUser(userDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserDto userDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));
        System.out.println("tttttttttt");

        String token = JwtHelper.generateToken(userDto.getEmail());
        System.out.println(token);

        return ResponseEntity.ok(new LoginResponse(userDto.getEmail(), token));
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> tokenValidation() {

        return ResponseEntity.ok().build();
    }

//    @PostMapping("/send")
//    public void sendMessageToKafka(@RequestBody String message) {
//        kafkaProducer.sendMessage(message);
//    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
       return ResponseEntity.ok().build();
    }
}
