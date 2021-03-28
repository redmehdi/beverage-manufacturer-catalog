package com.red.one.haufe.controller.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BeverageDto {

  @JsonProperty("PRICE_LIST")
  private UUID id;

  @JsonProperty("PRICE")
  private String price;

  @JsonProperty("PRODUCT_ID")
  private String product_id;

  @JsonProperty("BRAND_ID")
  private Integer brandId;

  private LocalDate startDate;

  private LocalDate endDate;

  private String currency;
}