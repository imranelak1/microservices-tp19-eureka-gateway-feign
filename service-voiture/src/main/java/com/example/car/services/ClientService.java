package com.example.car.services;
import com.example.car.models.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
@FeignClient(name="SERVICE-CLIENT",url="${client.base-url:}")
public interface ClientService {
    @GetMapping("/clients/{id}") Client clientById(@PathVariable("id") Long id);
}
