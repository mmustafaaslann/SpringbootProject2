package org.mustafa.aslan.config;

import org.mustafa.aslan.entity.User;
import org.mustafa.aslan.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class UserConfig {

    /*
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User user1 = new User(
                    "Ahmet1",
                    "T1"
                    ,"ahmet1@mail.com",
                    "pass1",
                    11,
                    LocalDate.of(2006, 12, 11)
            );

            User user2 = new User(
                    "Ahmet2",
                    "T2"
                    ,"ahmet2@mail.com",
                    "pass2",
                    12,
                    LocalDate.of(2000, 4, 24)
            );
            repository.saveAll(List.of(user1, user2));
        };
    }

     */


}
