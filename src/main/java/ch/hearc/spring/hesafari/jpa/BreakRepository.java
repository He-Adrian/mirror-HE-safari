package ch.hearc.spring.hesafari.jpa;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ch.hearc.spring.hesafari.model.Break;

public interface BreakRepository extends JpaRepository<Break, Long> {
// this a dynamic request so we cannot use @query annotation
	public default List<Break> findAllByLocation(String location) {
		return this.findAll().stream().filter(b -> b.getLocation().toUpperCase().contains(location.toUpperCase()))
				.collect(Collectors.toList());
	}
}