package apitestime.example.demo.service;

import apitestime.example.demo.Dto.UserDto;
import apitestime.example.demo.entity.User;
import apitestime.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;


    public void addUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        String password12 = userDto.getPassword();
        String hashedPassword = passwordEncoder.encode(password12);
        //ash+1=xyz
       // System.out.println(hashedPassword);
        user.setPassword(hashedPassword);
        user.setFirstName(user.getFirstName());
        user.setLastName(userDto.getLastName());
        this.userRepository.save(user);
    }
}
