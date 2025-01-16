package wav.hmed.microserviceutilisateur.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import wav.hmed.microserviceutilisateur.model.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}
