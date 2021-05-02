package ch.hearc.spring.hesafari.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import ch.hearc.spring.hesafari.model.Break;
import ch.hearc.spring.hesafari.model.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RepositoryTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private BreakRepository breakRepo;

	// test methods go below
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setUsername("Raxus");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode("testpass");
		user.setPassword(encodedPassword);
		user.setRole("User");
		user.setClassName("DLMA");

		User savedUser = userRepo.save(user);

		User existUser = entityManager.find(User.class, savedUser.getUserID());

		boolean test = passwordEncoder.matches("testpass", encodedPassword);
		assertThat(test).isTrue();
		assertThat(user.getUsername()).isEqualTo(existUser.getUsername());
		assertThat(user.getPassword()).isEqualTo(encodedPassword);
		assertThat(passwordEncoder.matches("testpass", user.getPassword())).isTrue();
	}
}