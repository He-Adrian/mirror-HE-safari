package ch.hearc.spring.hesafari.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.hearc.spring.hesafari.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}