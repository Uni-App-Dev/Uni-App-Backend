package br.com.uniapp.Person;

import br.com.uniapp.Person.model.Person;
import br.com.uniapp.smallGroup.model.SmallGroup;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Modifying
    @Query("update Person p set p.smallGroup = :smallGroup where p.id = :personId")
    void bindSmallGroup(@Param("smallGroup") SmallGroup smallGroup, @Param("personId") Long personId);

    @Modifying
    @Query("update Person p set p.smallGroupLead = :smallGroup where p.id = :personId")
    void bindSmallGroupLead(@Param("smallGroup") SmallGroup smallGroup, @Param("personId") Long personId);
}
