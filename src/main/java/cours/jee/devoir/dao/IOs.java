package cours.jee.devoir.dao;

import cours.jee.devoir.model.Os;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOs extends JpaRepository<Os, Long> {
}
