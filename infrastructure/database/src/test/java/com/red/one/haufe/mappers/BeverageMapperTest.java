package com.red.one.haufe.mappers;

import com.red.one.haufe.BaseTest;
import com.red.one.haufe.domain.entities.Beverage;
import com.red.one.haufe.entities.BeverageEntity;

import static org.junit.Assert.*;

import org.junit.Test;

public class BeverageMapperTest extends BaseTest {

  public static final String DESCRIPTION = "description";

  public static final String NAME = "name";

  public static final Long ID = 1L;

  public static final String TYPE = "type";

  public static final Double GRADUATION = Double.valueOf(20);

  private BeverageMapper mapper = new BeverageMapperImpl();

  @Test
  public void mapToDomainSpecies_whenNull_shouldReturnNull() {
    final Beverage result = mapper.map((BeverageEntity) null);

    assertNull(result);
  }

  @Test
  public void mapToDomain_whenNullParams_shouldExpectedValues() throws Exception {
    final BeverageEntity expected = new BeverageEntity(null, null, null, null, null, null);
    setField(expected, "id", null);

    final Beverage result = mapper.map(expected);

    assertNotNull(result);
    assertNull(result.getId());
    assertNull(result.getName());
    assertNull(result.getDescription());
    assertNull(result.getType());
    assertNull(result.getGraduation());
  }

  /**
   @Test public void mapToDomainSpecies_whenNotNullParams_shouldExpectedValues() {
   final BeverageEntity expected = new BeverageEntity(COLOR, NAME, URL, idExt);

   final Beverage result = mapper.map(expected);

   assertNotNull(result);
   assertEquals(expected.getColor(),result.getColor());
   assertEquals(expected.getName(),result.getName());
   assertNull(result.getId());
   }

   @Test public void mapToDomainSpecies_whenNullColor_shouldExpectedValues() {
   final BeverageEntity expected = new BeverageEntity(null, NAME, URL, idExt);

   final Beverage result = mapper.map(expected);

   assertNotNull(result);
   assertNull(result.getColor());
   assertEquals(expected.getName(),result.getName());
   assertNull(result.getId());
   }

   @Test public void mapToDomainSpecies_whenNullName_shouldExpectedValues() {
   final BeverageEntity expected = new BeverageEntity(COLOR, null, URL, idExt);

   final Beverage result = mapper.map(expected);

   assertNotNull(result);
   assertNull(result.getName());
   assertEquals(expected.getColor(),result.getColor());
   assertNull(result.getId());
   }

   @Test public void mapToDomainSpecies_whenNullPokeCharacter_shouldExpectedValues() {
   final BeverageEntity expected = new BeverageEntity(COLOR, NAME, URL, idExt);

   final Beverage result = mapper.map(expected);

   assertNotNull(result);
   assertNotNull(result.getName());
   assertNotNull(result.getColor());
   assertNull(result.getId());
   }

   /***
   @Test public void mapToDomainCharacter_whenNullParams_shouldExpectedValues() {

   final PokeCharacter result = mapper.map(expected);

   assertNotNull(result);
   assertNull(result.getId());
   assertNull(result.getName());
   assertNull(result.getHeight());
   assertNull(result.getWeight());
   assertNull(result.getBaseExperience());
   }

   @Test public void mapToDomainCharacter_whenNotNullParams_shouldExpectedValues() {
   final BeverageEntity speciesEntity = new BeverageEntity(COLOR, NAME, URL, idExt, null);
   final PokeCharacterEntity expected = new PokeCharacterEntity(NAME, 3, 4,5,speciesEntity);

   final PokeCharacter result = mapper.map(expected);

   assertNotNull(result);
   assertNull(result.getId());
   assertNotNull(result.getName());
   assertNotNull(result.getHeight());
   assertNotNull(result.getWeight());
   assertNotNull(result.getBaseExperience());
   }

   @Test public void mapToDomainCharacter_whenNullName_shouldExpectedValues() {
   final BeverageEntity speciesEntity = new BeverageEntity(COLOR, NAME, URL, idExt, null);
   final PokeCharacterEntity expected = new PokeCharacterEntity(null, 3, 4,5,speciesEntity);

   final PokeCharacter result = mapper.map(expected);

   assertNotNull(result);
   assertNull(result.getId());
   assertNull(result.getName());
   assertNotNull(result.getHeight());
   assertNotNull(result.getWeight());
   assertNotNull(result.getBaseExperience());
   }

   @Test public void mapToDomainCharacter_whenNullBaseExperience_shouldExpectedValues() {
   final BeverageEntity speciesEntity = new BeverageEntity(COLOR, NAME, URL, idExt, null);
   final PokeCharacterEntity expected = new PokeCharacterEntity(NAME, null, 4,5,speciesEntity);

   final PokeCharacter result = mapper.map(expected);

   assertNotNull(result);
   assertNull(result.getId());
   assertNotNull(result.getName());
   assertNotNull(result.getHeight());
   assertNotNull(result.getWeight());
   assertNull(result.getBaseExperience());
   }

   @Test public void mapToDomainCharacter_whenNullHeight_shouldExpectedValues() {
   final BeverageEntity speciesEntity = new BeverageEntity(COLOR, NAME, URL, idExt, null);
   final PokeCharacterEntity expected = new PokeCharacterEntity(NAME, 43, null,5,speciesEntity);

   final PokeCharacter result = mapper.map(expected);

   assertNotNull(result);
   assertNull(result.getId());
   assertNotNull(result.getName());
   assertNull(result.getHeight());
   assertNotNull(result.getWeight());
   assertNotNull(result.getBaseExperience());
   }

   @Test public void mapToDomainCharacter_whenNullWeight_shouldExpectedValues() {
   final BeverageEntity speciesEntity = new BeverageEntity(COLOR, NAME, URL, idExt, null);
   final PokeCharacterEntity expected = new PokeCharacterEntity(NAME, 43, 324,null,speciesEntity);

   final PokeCharacter result = mapper.map(expected);

   assertNotNull(result);
   assertNull(result.getId());
   assertNotNull(result.getName());
   assertNotNull(result.getHeight());
   assertNull(result.getWeight());
   assertNotNull(result.getBaseExperience());
   }*/
}