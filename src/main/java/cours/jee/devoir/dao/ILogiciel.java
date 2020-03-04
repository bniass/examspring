package cours.jee.devoir.dao;

import cours.jee.devoir.model.Logiciel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILogiciel extends JpaRepository<Logiciel, Long> {
}
