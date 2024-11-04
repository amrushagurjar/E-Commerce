package apitestime.example.demo.controller;

import apitestime.example.demo.Entity.UserDto;
import apitestime.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
   private UserService userService;

    @GetMapping("/allusers")
    public ResponseEntity<List<UserDto>> getUserList() {
        return ResponseEntity.ok(this.userService.getUserList());
    }

    @GetMapping("/alluser/{id}")
    public ResponseEntity<String> getUserName(@PathVariable int id) {
        UserDto user = this.userService.getUser(id);
        return ResponseEntity.ok(user.);
    }

    @PostMapping("/alluser")
    public void addUser(@RequestBody UserDto user) {
        userService.addUser(user);
    }
}
