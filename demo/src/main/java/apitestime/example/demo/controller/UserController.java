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


    private final SignUpService signUpService;
   // private LoginResponse LoginResponse;


    private final LoginService loginService;
    private final AuthenticationManager authenticationManager;

//    @GetMapping("/allusers")
//    public ResponseEntity<List<UserDto>> getUserList() {
//
//        return ResponseEntity.ok(this.userService.getUserList());
//    }
//
//    @GetMapping("/alluser/{id}")
//    public ResponseEntity<String> getUserName(@PathVariable int id) {
//        UserDto user = this.userService.getUser(id);
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/alluser")
//    public void addUser(@RequestBody UserDto user) {
//        userService.addUser(user);
//    }


    @PostMapping("/signUp")
    public ResponseEntity<Void> signUp(@RequestBody UserDto userDto) {
        this.signUpService.addUser(userDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserDto userDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword()));
        System.out.println("tttttttttt");
        return null;
        //String token = JwtHelper.generateToken(userDto.getEmail());
       // return ResponseEntity.ok(new LoginResponse(userDto.getEmail(), token));

    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> tokenValidation() {

        return ResponseEntity.ok().build();
    }


}
