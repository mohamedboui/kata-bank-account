package com.bank.kata.mapper;

import com.bank.kata.domain.Account;
import com.bank.kata.domain.Client;
import com.bank.kata.dto.AccountDTO;
import com.bank.kata.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring",uses = {AuditableDTOMapper.class})
public interface AccountDTOMapper extends DomainDTOMapper<Account, AccountDTO> {

    @Mapping(target="client.id", source="accountDTO.clientId")
    Account toDomainObject(AccountDTO accountDTO);
}
