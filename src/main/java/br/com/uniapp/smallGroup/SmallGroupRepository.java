package br.com.uniapp.smallGroup;

import br.com.uniapp.smallGroup.model.SmallGroup;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface SmallGroupRepository extends JpaRepository<SmallGroup, Long> {
}
