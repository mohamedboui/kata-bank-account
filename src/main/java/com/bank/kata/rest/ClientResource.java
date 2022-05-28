package com.bank.kata.rest;

import com.bank.kata.domain.Client;
import com.bank.kata.dto.ClientDTO;
import com.bank.kata.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientResource {
    private final ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping()
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO clientDTO) {

        Client client = clientService.createClient(clientDTO);

        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<Client>> findAllAccounts() {

        List<Client> clients = clientService.getAllClients();

        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
}
