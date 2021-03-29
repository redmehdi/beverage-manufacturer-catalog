package com.red.one.haufe.domain.ports;

import com.red.one.haufe.domain.entities.Beverage;
import com.red.one.haufe.domain.entities.BeverageAggregate;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Mono;

public interface BeveragePort {

  Optional<Beverage> findById(final Long id);

  Optional<BeverageAggregate> findDetailById(final Long id);

  Page<Beverage> findAll(Pageable pageable);

  Beverage save(Beverage beverage);
}
