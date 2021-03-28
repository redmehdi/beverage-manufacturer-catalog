package com.red.one.haufe.domain.services;

import com.red.one.haufe.domain.entities.Beverage;
import com.red.one.haufe.domain.ports.BeveragePort;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BeverageService implements IBeverageService {

    private final BeveragePort port;

    public BeverageService(final BeveragePort port) {
        this.port = port;
    }

    @Override
    public Mono<Beverage> getCurrentPrice(final LocalDate localDate, final Long productId, final Integer brandId) {
        return this.port.findPrice(localDate, productId, brandId);
    }
}