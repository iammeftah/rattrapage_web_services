package wav.hmed.microservicepret.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import wav.hmed.microservicepret.model.Pret;

public interface PretRepository extends JpaRepository<Pret, Long> {
}