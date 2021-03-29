package com.red.one.haufe.domain.services;

import com.red.one.haufe.domain.entities.Beverage;
import com.red.one.haufe.domain.entities.BeverageAggregate;
import com.red.one.haufe.domain.ports.BeveragePort;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BeverageService implements IBeverageService {

  private final BeveragePort port;

  public BeverageService(final BeveragePort port) {
    this.port = port;
  }

  @Override
  public Optional<Beverage> findById(Long id) {
    return port.findById(id);
  }

  @Override
  public Optional<BeverageAggregate> findDetailById(final Long id) {
    return port.findDetailById(id);
  }

  @Override
  public Page<Beverage> findAll(Pageable pageable) {
    return port.findAll(pageable);
  }

  @Override
  public Beverage save(Beverage beverage) {
    return port.save(beverage);
  }
}