package ch.hearc.spring.hesafari.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import ch.hearc.spring.hesafari.model.User;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
 
    @Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private UserRepository repo;
     
    // test methods go below
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUsername("Raxus");
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode("testpass");
        user.setPassword(encodedPassword);
        user.setRole("Admin");
        user.setClassName("DLMA");
         
        User savedUser = repo.save(user);
         
        User existUser = entityManager.find(User.class, savedUser.getUserID());
        
        boolean test = passwordEncoder.matches("testpass", encodedPassword);
        assertThat(user.getUsername()).isEqualTo(existUser.getUsername());
        assertThat(user.getPassword()).isEqualTo(encodedPassword);
         
    }
}