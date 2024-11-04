package apitestime.example.demo.service;
import apitestime.example.demo.Entity.UserDto;
import apitestime.example.demo.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
 private  UserRepositories userRepositories;
public List<UserDto> getUserList(){
    try {
        return this.userRepositories.findAll();
    }
    catch(DataAccessException e ){
         throw new RuntimeException("Could not retrieve list .please try again");
    }
}

public UserDto getUser(int id){
    try {
        Optional<UserDto> getUserDetails = this.userRepositories.findById(id);
        return getUserDetails.orElse(null);
    }
  catch(DataAccessException e){
      throw new RuntimeException("Could not retrieve user  .please try again");
  }
}
public void addUser(UserDto user){
    try {
        userRepositories.save(user);
    } catch (Exception e) {
        throw new RuntimeException("Could not add  user");
    }
}
}
