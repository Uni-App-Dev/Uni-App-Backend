package br.com.uniapp.repository;

import br.com.uniapp.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
