package implementingspringsecuritywithauthentication;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import implementingspringsecrityauthentication.domain.User;
import implementingspringsecrityauthentication.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ImplementingSpringSecurityWithAuthenticationApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ImplementingSpringSecurityWithAuthenticationApplication.class, args);
    }


    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user = User.builder()
                .username("chris")
                .password("12345")
                .roles("ROLE_USER")
                .build();

        User user1 = User.builder()
                .username("ellie")
                .password("123")
                .roles("ROLE_USER")
                .build();

        User user2 = User.builder()
                .username("foo")
                .password("123")
                .roles("ROLE_USER")
                .build();

        userRepository.save(user);
        userRepository.save(user1);
        userRepository.save(user2);

    }
}
