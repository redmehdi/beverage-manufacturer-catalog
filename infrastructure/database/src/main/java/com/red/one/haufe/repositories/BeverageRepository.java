package com.red.one.haufe.repositories;

import com.red.one.haufe.entities.BeverageEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeverageRepository extends PagingAndSortingRepository<BeverageEntity, Long> {

}