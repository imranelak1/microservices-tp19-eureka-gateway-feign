package com.example.car.repositories;
import com.example.car.entities.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CarRepository extends JpaRepository<Voiture,Long> { List<Voiture> findByClientId(Long clientId); }
