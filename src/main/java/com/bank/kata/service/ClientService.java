package com.bank.kata.service;

import com.bank.kata.domain.Client;
import com.bank.kata.dto.ClientDTO;

import java.util.List;

public interface ClientService {
  Client createClient(ClientDTO clientDTO);
  List<Client> getAllClients();
}
