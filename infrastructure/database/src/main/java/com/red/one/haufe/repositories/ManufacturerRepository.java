package com.red.one.haufe.repositories;

import com.red.one.haufe.entities.ManufacturerEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends PagingAndSortingRepository<ManufacturerEntity, Long> {

}