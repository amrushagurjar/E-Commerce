package apitestime.example.demo.repositories;

import apitestime.example.demo.Entity.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<UserDto,Integer> {
}
