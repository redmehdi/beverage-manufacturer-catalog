package com.red.one.haufe.repositories;

import com.red.one.haufe.domain.entities.Beverage;
import com.red.one.haufe.domain.entities.BeverageAggregate;
import com.red.one.haufe.domain.ports.BeveragePort;
import com.red.one.haufe.mappers.BeverageMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component("beerAdapter")
public class BeverageAdapter implements BeveragePort {

    private final BeverageRepository repository;
    private final BeverageMapper mapper;

    public BeverageAdapter(final BeverageRepository repository, final BeverageMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<BeverageAggregate> findDetailById(final Long id) {
        return repository.findById(id).map(this.mapper::mapDetail);
    }

    @Override
    public Optional<Beverage> findById(final Long id) {
        return repository.findById(id).map(this.mapper::map);
    }

    @Override
    public Page<Beverage> findAll(final Pageable pageable) {
        return repository.findAll(pageable).map(this.mapper::map);
    }

    @Override
    public Beverage save(final Beverage beverage) {
        return this.mapper.map(repository.save(this.mapper.map(beverage)));
    }
}