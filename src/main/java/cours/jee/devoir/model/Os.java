package cours.jee.devoir.model;

import javax.persistence.*;
import java.util.*;
import java.io.Serializable;
@Entity
public class Os implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String libelle;
    @OneToMany(mappedBy = "os", fetch = FetchType.EAGER)
    private List<Ordinateur> ordinateurs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Ordinateur> getOrdinateurs() {
        return ordinateurs;
    }

    public void setOrdinateurs(List<Ordinateur> ordinateurs) {
        this.ordinateurs = ordinateurs;
    }
}
