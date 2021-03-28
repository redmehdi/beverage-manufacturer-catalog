package com.red.one.haufe.controller.mappers;

import com.red.one.haufe.controller.dtos.BeverageDto;
import com.red.one.haufe.domain.entities.Beverage;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BeverageDtoMapper {

    BeverageDto map(final Beverage domain);
}