package wav.hmed.microservicepret.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wav.hmed.microservicepret.model.Pret;
import wav.hmed.microservicepret.service.PretService;

import java.util.List;

@RestController
@RequestMapping("/prets")
public class PretController {

    @Autowired
    private PretService pretService;

    @GetMapping
    public List<Pret> getAllPrets() {
        return pretService.getAllPrets();
    }

    @PostMapping
    public Pret addPret(@RequestBody Pret pret) {
        return pretService.addPret(pret);
    }
}