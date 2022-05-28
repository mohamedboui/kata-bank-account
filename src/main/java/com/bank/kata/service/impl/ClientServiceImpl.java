package com.bank.kata.service.impl;


import com.bank.kata.domain.Client;
import com.bank.kata.dto.ClientDTO;
import com.bank.kata.mapper.ClientMapper;
import com.bank.kata.repository.ClientRepository;
import org.springframework.stereotype.Service;

import com.bank.kata.service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public Client createClient(ClientDTO clientDTO) {
        Client client = this.clientMapper.toDomainObject(clientDTO);
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
