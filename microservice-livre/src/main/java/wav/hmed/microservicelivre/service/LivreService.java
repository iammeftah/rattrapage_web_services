package wav.hmed.microservicelivre.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wav.hmed.microservicelivre.model.Livre;
import wav.hmed.microservicelivre.repository.LivreRepository;

import java.util.List;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public Livre getLivreById(Long id) {
        return livreRepository.findById(id).orElse(null);
    }

    public Livre addLivre(Livre livre) {
        return livreRepository.save(livre);
    }
}