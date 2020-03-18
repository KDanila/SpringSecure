package ru.kdv.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.kdv.entity.User;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ComponentScan("ru.kdv")
@ExtendWith(SpringExtension.class)
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void getByIdTest(){
        Long id = 1L;
        Optional<User> user = userRepository.findById(id);
    }

}