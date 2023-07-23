package br.com.uniapp.person;

import br.com.uniapp.person.model.Person;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

@Transactional
public interface PersonRepository extends JpaRepository<Person, Long> {

    Collection<Person> findBySmallGroupId(Long smallGroupId);
}
