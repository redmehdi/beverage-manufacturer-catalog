package com.red.one.haufe.domain.services;

import com.red.one.haufe.domain.entities.Beverage;

public final class BeverageDataset {

  public static Beverage[] getBeers() {
    return new Beverage[]{new Beverage(1L, "name1", "description1", "type1", Double.valueOf(21)),
        new Beverage(2L, "name2", "description2", "type2", Double.valueOf(21)),
        new Beverage(3L, "name3", "description3", "type3", Double.valueOf(21)),
        new Beverage(4L, "name4", "description4", "type4", Double.valueOf(21)),
        new Beverage(5L, "name5", "description5", "type5", Double.valueOf(21))};
  }
}
