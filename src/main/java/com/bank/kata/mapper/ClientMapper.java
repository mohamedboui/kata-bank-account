package com.bank.kata.mapper;

import com.bank.kata.domain.Client;
import com.bank.kata.dto.ClientDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper extends DomainDTOMapper<Client,ClientDTO> {

}
