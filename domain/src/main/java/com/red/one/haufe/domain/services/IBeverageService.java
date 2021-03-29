package com.red.one.haufe.domain.services;

import com.red.one.haufe.domain.entities.Beverage;
import com.red.one.haufe.domain.entities.BeverageAggregate;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBeverageService {

  Optional<Beverage> findById(final Long id);

  Optional<BeverageAggregate> findDetailById(final Long id);

  Page<Beverage> findAll(Pageable pageable);

  Beverage save(Beverage beverage);
}