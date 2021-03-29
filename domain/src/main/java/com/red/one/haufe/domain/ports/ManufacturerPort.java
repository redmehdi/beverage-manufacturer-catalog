package com.red.one.haufe.domain.ports;

import com.red.one.haufe.domain.entities.Beverage;
import com.red.one.haufe.domain.entities.BeverageAggregate;
import com.red.one.haufe.domain.entities.Manufacturer;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ManufacturerPort {

  Optional<Manufacturer> findById(Long id);

  Page<Manufacturer> findAll(Pageable pageable);

  Manufacturer save(Manufacturer beverage);
}
