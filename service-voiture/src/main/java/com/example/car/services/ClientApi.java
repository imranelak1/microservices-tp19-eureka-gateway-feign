package com.example.car.services;
import com.example.car.models.Client;
import org.springframework.stereotype.Service;
/** Communication synchrone feign : résolution et transport restent hors du contrôleur. */
@Service
public class ClientApi { private final ClientService client;
        public ClientApi(ClientService client) { this.client=client; }
        public Client findClientById(Long id) { return client.clientById(id); } }
