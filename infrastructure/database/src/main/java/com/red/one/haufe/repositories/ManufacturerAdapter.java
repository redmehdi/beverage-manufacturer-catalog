package com.red.one.haufe.repositories;

import com.red.one.haufe.domain.entities.Manufacturer;
import com.red.one.haufe.domain.ports.ManufacturerPort;
import com.red.one.haufe.mappers.ManufacturerMapper;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component("manufacturerAdapter")
public class ManufacturerAdapter implements ManufacturerPort {

  private final ManufacturerRepository repository;

  private final ManufacturerMapper mapper;

  public ManufacturerAdapter(final ManufacturerRepository repository, final ManufacturerMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public Optional<Manufacturer> findById(final Long id) {
    return repository.findById(id).map(this.mapper::map);
  }

  @Override
  public Page<Manufacturer> findAll(final Pageable pageable) {
    return repository.findAll(pageable).map(this.mapper::map);
  }

  @Override
  public Manufacturer save(final Manufacturer beverage) {
    return this.mapper.map(repository.save(this.mapper.map(beverage)));
  }
}