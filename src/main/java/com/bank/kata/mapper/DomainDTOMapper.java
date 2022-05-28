package com.bank.kata.mapper;


import java.util.List;
import java.util.Map;

public interface DomainDTOMapper<B, D> {

    B toDomainObject(D dto);

    D toDto(B domainObject);

    List<B> toDomainsObjects(List<D> dtos);

    List<D> toDtos(List<B> domainObjects);

    Map<String, List<D>> toMapDtos(Map<String, List<B>> dtos);

}
