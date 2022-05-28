package com.bank.kata.mapper;

import com.bank.kata.domain.AuditableEntity;
import com.bank.kata.dto.AuditableDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuditableDTOMapper extends DomainDTOMapper<AuditableEntity, AuditableDTO> {
}
