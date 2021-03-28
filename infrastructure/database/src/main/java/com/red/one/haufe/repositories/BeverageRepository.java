package com.red.one.haufe.repositories;

import com.red.one.haufe.entities.BeverageEntity;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface BeverageRepository extends ReactiveMongoRepository<BeverageEntity, UUID> {

//    @Query("SELECT p FROM Beverage p WHERE :localDate BETWEEN p.startDate AND p.endDate AND p.productId = :productId AND p.brandId= :brandId ORDER BY p.startDate, p.priority DESC")
    @Query("{ $and: [ {?0 : { $gt: 'startDate', $lt: 'endDate'}}, { 'productId': ?1 }, { 'brandId': ?2 } }],"
        + " { $sort: { 'startDate':-1,  priority: -1 }, "
        + "{ $limit : 1 } }")
    Mono<BeverageEntity> findFirst(final LocalDate localDate, final Long productId, final Integer brandId);
}
