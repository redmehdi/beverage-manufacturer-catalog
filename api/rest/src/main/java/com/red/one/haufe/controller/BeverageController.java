package com.red.one.haufe.controller;

import com.red.one.haufe.controller.dtos.BeverageDto;
import com.red.one.haufe.controller.mappers.BeverageDtoMapper;
import com.red.one.haufe.domain.services.IBeverageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalogue")
public class BeverageController {

  private final IBeverageService service;

  private final BeverageDtoMapper mapper;

  public BeverageController(final IBeverageService service, final BeverageDtoMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  /**
   * Retrieves  compain
   */
  @GetMapping(value = "/")
  Page<BeverageDto> getAll(Pageable pageable) {
    return service.findAll(pageable).map(this.mapper::map);
  }
}