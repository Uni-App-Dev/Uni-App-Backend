package br.com.uniapp.Person;

import br.com.uniapp.Person.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface PersonRepository extends JpaRepository<Person, Long> {
}
