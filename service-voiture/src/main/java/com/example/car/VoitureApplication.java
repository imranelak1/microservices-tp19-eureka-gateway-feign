package com.example.car;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import com.example.car.entities.Voiture;
import com.example.car.repositories.CarRepository;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication @EnableDiscoveryClient @EnableFeignClients
public class VoitureApplication {
    public static void main(String[] args) { SpringApplication.run(VoitureApplication.class,args); }
    @Bean CommandLineRunner seed(CarRepository repository) {
        return args -> { if(repository.count()==0) {
            repository.save(new Voiture(null,"Toyota","Yaris","A 25 333",1L,null));
            repository.save(new Voiture(null,"Renault","Megane","B 6 3456",1L,null));
            repository.save(new Voiture(null,"Peugeot","301","A 55 4444",2L,null));
        } };
    }
}
