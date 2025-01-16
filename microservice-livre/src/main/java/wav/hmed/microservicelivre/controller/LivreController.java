package wav.hmed.microservicelivre.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wav.hmed.microservicelivre.model.Livre;
import wav.hmed.microservicelivre.service.LivreService;

import java.util.List;

@RestController
@RequestMapping("/livres")
public class LivreController {

    @Autowired
    private LivreService livreService;

    @GetMapping
    public List<Livre> getAllLivres() {
        return livreService.getAllLivres();
    }

    @GetMapping("/{id}")
    public Livre getLivreById(@PathVariable Long id) {
        return livreService.getLivreById(id);
    }

    @PostMapping
    public Livre addLivre(@RequestBody Livre livre) {
        return livreService.addLivre(livre);
    }
}