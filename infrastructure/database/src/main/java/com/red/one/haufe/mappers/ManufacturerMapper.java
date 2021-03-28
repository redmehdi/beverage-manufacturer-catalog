package com.red.one.haufe.mappers;

import com.red.one.haufe.domain.entities.Manufacturer;
import com.red.one.haufe.entities.ManufacturerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ManufacturerMapper {

  Manufacturer map(final ManufacturerEntity entity);

  ManufacturerEntity map(final Manufacturer domain);
}