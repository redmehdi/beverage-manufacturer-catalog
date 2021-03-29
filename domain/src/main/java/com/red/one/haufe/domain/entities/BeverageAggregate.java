package com.red.one.haufe.domain.entities;

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
public class BeverageAggregate {

  private Long id;

  private String name;

  private String description;

  private String type;

  private Double graduation;

  private Manufacturer manufacturer;
}
