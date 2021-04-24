package ch.hearc.spring.hesafari.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ch.hearc.spring.hesafari.model.Break;

public interface BreakRepository extends JpaRepository<Break, Long> {
	@Query("SELECT u FROM Break u WHERE u.location = ?1")
    public Break findByLocation(String location);
}