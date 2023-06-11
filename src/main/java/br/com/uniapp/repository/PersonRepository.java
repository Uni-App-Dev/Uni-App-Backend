package br.com.uniapp.repository;

import br.com.uniapp.model.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface PersonRepository extends JpaRepository<Person, Long> {
}
