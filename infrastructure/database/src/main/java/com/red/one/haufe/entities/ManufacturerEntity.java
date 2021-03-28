package com.red.one.haufe.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Manufacturer")
public class ManufacturerEntity extends AuditEntity {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY) Long id;

  private String name;

  private String nationality;

  private String description;

  @OneToMany
  private List<BeverageEntity> beverages;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }
}