package com.red.one.haufe.controller;

import com.red.one.haufe.controller.dtos.BeverageDto;
import com.red.one.haufe.controller.mappers.BeverageDtoMapper;
import com.red.one.haufe.domain.services.IBeverageService;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/catalog")
public class BeverageController {

    private final IBeverageService service;
    private final BeverageDtoMapper mapper;

    public BeverageController(final IBeverageService service, final BeverageDtoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    /**
     * Retrieves pricing compain
     *
     * @return
     */
    @GetMapping(value = "/")
    Mono<BeverageDto> getTop5ByHeight(final LocalDate localDate, final Long productId, final Integer brandId) {
        return service.getCurrentPrice(localDate, productId, brandId).map(this.mapper::map);
    }
}