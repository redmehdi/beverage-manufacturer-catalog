package com.red.one.haufe.entities;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@Document(collection = "Beverage")
public class BeverageEntity extends AuditEntity {

  private final LocalDate endDate;

  private final LocalDate startDate;

  private final UUID id;

  private final Integer brandId;

  private final Long productId;

  private final Double price;

  private final String currency;

  private final Integer priority;

  protected BeverageEntity() {
      this.id = null;
      this.brandId = null;
      this.startDate = null;
      this.endDate = null;
      this.productId = null;
      this.price = null;
      this.currency = null;
      this.priority = null;
  }
}