package com.red.one.haufe.domain.entities;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Beverage {

  private UUID id;

  private Integer brandId;

  private LocalDate startDate;

  private LocalDate endDate;

  private Long productId;

  private Double price;

  private String currency;
}