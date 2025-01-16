package wav.hmed.microservicepret.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import wav.hmed.microservicepret.client.LivreClient;
import wav.hmed.microservicepret.model.Pret;
import wav.hmed.microservicepret.repository.PretRepository;

import java.util.List;

@Service
public class PretService {

    @Autowired
    private PretRepository pretRepository;

    @Autowired
    private LivreClient livreClient;

    // Enregistrer un prêt avec vérification de la disponibilité du livre
    @CircuitBreaker(name = "livreService", fallbackMethod = "fallbackEnregistrerPret")
    public Pret addPret(Pret pret) {
        // Vérifier si le livre existe et est disponible
        String livreDetails = livreClient.getLivreDetails(pret.getLivreId());
        if (livreDetails == null || livreDetails.contains("indisponible")) {
            throw new RuntimeException("Livre non disponible");
        }

        // Enregistrer le prêt
        return pretRepository.save(pret);
    }

    // Fallback method en cas de panne du microservice Livre
    public Pret fallbackEnregistrerPret(Pret pret, Throwable t) {
        // Log l'erreur
        System.out.println("Fallback activé : Service Livre indisponible");

        // Retourner un prêt factice ou lever une exception
        throw new RuntimeException("Service Livre indisponible. Impossible d'enregistrer le prêt.");
    }

    private final RestTemplate restTemplate;

    public PretService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "livreService", fallbackMethod = "fallbackGetLivre")
    public String getLivreDetails(Long livreId) {
        return restTemplate.getForObject("http://localhost:8081/livres/" + livreId, String.class);
    }

    public List<Pret> getAllPrets() {
        return pretRepository.findAll();
    }
}