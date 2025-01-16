package wav.hmed.microservicelivre.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import wav.hmed.microservicelivre.model.Livre;

public interface LivreRepository extends JpaRepository<Livre, Long> {
}