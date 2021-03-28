package com.red.one.haufe.domain.ports;

import com.red.one.haufe.domain.entities.Beverage;
import java.time.LocalDate;
import reactor.core.publisher.Mono;

public interface BeveragePort {

  Mono<Beverage> findPrice(final LocalDate localDate, final Long productId, final Integer brandId);
}
