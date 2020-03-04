package cours.jee.devoir.dao;

import cours.jee.devoir.model.Ordinateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdinateur extends JpaRepository<Ordinateur, Long> {
}
