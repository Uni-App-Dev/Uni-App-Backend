package br.com.uniapp.Person;

import br.com.uniapp.Person.model.Person;
import br.com.uniapp.smallGroup.model.SmallGroup;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

@Transactional
public interface PersonRepository extends JpaRepository<Person, Long> {

    Collection<Person> findBySmallGroupId(Long smallGroupId);
}
