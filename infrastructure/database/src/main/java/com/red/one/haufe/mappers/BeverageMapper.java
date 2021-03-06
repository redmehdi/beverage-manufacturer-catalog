package com.red.one.haufe.mappers;

import com.red.one.haufe.domain.entities.Beverage;
import com.red.one.haufe.domain.entities.BeverageAggregate;
import com.red.one.haufe.entities.BeverageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = ManufacturerMapper.class)
public interface BeverageMapper {

    Beverage map(final BeverageEntity entity);

    BeverageAggregate mapDetail(final BeverageEntity entity);

    BeverageEntity map(final Beverage domain);
}