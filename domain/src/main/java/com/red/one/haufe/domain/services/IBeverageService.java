package com.red.one.haufe.domain.services;

import com.red.one.haufe.domain.entities.Beverage;
import java.time.LocalDate;
import reactor.core.publisher.Mono;

public interface IBeverageService {

    Mono<Beverage> getCurrentPrice(final LocalDate localDate, final Long productId, final Integer brandId);
}
