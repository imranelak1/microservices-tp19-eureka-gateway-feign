package com.example.car.controllers;
import com.example.car.entities.Voiture;
import com.example.car.services.*;
import com.example.car.models.Client;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@RestController @RequestMapping("/voitures")
public class CarController {
    private final CarService service;
    public CarController(CarService service) { this.service=service; }
    @GetMapping public List<Voiture> findAll() { return service.findAll(); }
    @GetMapping("/{id}") public Voiture findById(@PathVariable Long id) { return service.findById(id); }
    @GetMapping({"/client/{clientId}","/byClient/{clientId}"}) public List<Voiture> findByClient(@PathVariable Long clientId) { return service.findByClient(clientId); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Voiture save(@RequestBody Voiture input) { input.setId(null);return service.save(input); }
    @PostMapping("/{clientId}") public Voiture saveForClient(@PathVariable Long clientId,@RequestBody Voiture input) { input.setId(null);input.setClientId(clientId);return service.save(input); }
    @PutMapping("/{id}") public Voiture update(@PathVariable Long id,@RequestBody Voiture input) { return service.update(id,input); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) { service.delete(id); }
}
