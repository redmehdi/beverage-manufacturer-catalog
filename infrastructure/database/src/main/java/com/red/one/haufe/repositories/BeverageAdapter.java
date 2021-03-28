package com.red.one.haufe.repositories;

import com.red.one.haufe.domain.entities.Beverage;
import com.red.one.haufe.domain.ports.BeveragePort;
import com.red.one.haufe.mappers.BeverageMapper;
import java.time.LocalDate;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import reactor.core.publisher.Mono;

@Component("pricingAdapter")
public class BeverageAdapter implements BeveragePort {

    private final BeverageRepository repository;
    private final BeverageMapper mapper;

    public BeverageAdapter(final BeverageRepository repository, final BeverageMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Mono<Beverage> findPrice(final LocalDate localDate, final Long productId, final Integer brandId) {
        return repository.findFirst(localDate, productId, brandId).map(this.mapper::map);
    }

}