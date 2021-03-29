package com.red.one.haufe.mappers;

import com.red.one.haufe.BaseTest;
import com.red.one.haufe.domain.entities.Beverage;
import com.red.one.haufe.domain.entities.BeverageAggregate;
import com.red.one.haufe.domain.entities.Manufacturer;
import com.red.one.haufe.entities.BeverageEntity;

import static org.junit.Assert.*;

import com.red.one.haufe.entities.ManufacturerEntity;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class BeverageMapperTest extends BaseTest {

  public static final String DESCRIPTION = "description";

  public static final String NAME = "name";

  public static final Long ID = 1L;

  public static final String TYPE = "type";

  public static final Double GRADUATION = Double.valueOf(20);

  private BeverageMapper mapper = new BeverageMapperImpl();

  @Mock
  private ManufacturerMapper manufacturerMapper;

  @Override
  protected void setUp() throws Exception {
    setField(mapper, "manufacturerMapper", manufacturerMapper);
    super.setUp();
  }

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

  @Test
  public void mapToDomain_whenNotNullParams_shouldExpectedValues() throws Exception {
    final BeverageEntity expected = new BeverageEntity(ID, NAME, DESCRIPTION, TYPE, GRADUATION, null);

    final Beverage result = mapper.map(expected);

    assertNotNull(result);
    assertEquals(expected.getId(), result.getId());
    assertEquals(expected.getDescription(), result.getDescription());
    assertEquals(expected.getName(), result.getName());
    assertEquals(expected.getType(), result.getType());
    assertEquals(expected.getGraduation(), result.getGraduation());
  }

  @Test
  public void mapToDomain_whenNullGraduation_shouldExpectedValues() throws Exception {
    final BeverageEntity expected = new BeverageEntity(ID, NAME, DESCRIPTION, TYPE, null, null);

    final Beverage result = mapper.map(expected);

    assertNotNull(result);
    assertEquals(expected.getId(), result.getId());
    assertEquals(expected.getDescription(), result.getDescription());
    assertEquals(expected.getName(), result.getName());
    assertEquals(expected.getType(), result.getType());
    assertNull(result.getGraduation());
  }

  @Test
  public void mapToDomain_whenNullType_shouldExpectedValues() throws Exception {
    final BeverageEntity expected = new BeverageEntity(ID, NAME, DESCRIPTION, null, GRADUATION, null);

    final Beverage result = mapper.map(expected);

    assertNotNull(result);
    assertEquals(expected.getId(), result.getId());
    assertEquals(expected.getDescription(), result.getDescription());
    assertEquals(expected.getName(), result.getName());
    assertNull(result.getType());
    assertEquals(expected.getGraduation(), result.getGraduation());
  }

  @Test
  public void mapToDomain_whenNullName_shouldExpectedValues() throws Exception {
    final BeverageEntity expected = new BeverageEntity(ID, null, DESCRIPTION, TYPE, GRADUATION, null);

    final Beverage result = mapper.map(expected);

    assertNotNull(result);
    assertEquals(expected.getId(), result.getId());
    assertEquals(expected.getDescription(), result.getDescription());
    assertNull(result.getName());
    assertEquals(expected.getType(), result.getType());
    assertEquals(expected.getGraduation(), result.getGraduation());
  }

  @Test
  public void mapToDomain_whenNullDescription_shouldExpectedValues() throws Exception {
    final BeverageEntity expected = new BeverageEntity(ID, NAME, null, TYPE, GRADUATION, null);

    final Beverage result = mapper.map(expected);

    assertNotNull(result);
    assertEquals(expected.getId(), result.getId());
    assertEquals(expected.getName(), result.getName());
    assertNull(result.getDescription());
    assertEquals(expected.getType(), result.getType());
    assertEquals(expected.getGraduation(), result.getGraduation());
  }

  @Test
  public void mapToDomainAggregator_whenNull_shouldReturnNull() {
    final BeverageAggregate result = mapper.mapDetail((BeverageEntity) null);

    assertNull(result);
  }

  @Test
  public void mapToDomainAggregator_whenNullParams_shouldExpectedValues() throws Exception {
    final BeverageEntity expected = new BeverageEntity(null, null, null, null, null, new ManufacturerEntity());

    mockMapManufacturer(new Manufacturer());
    final BeverageAggregate result = mapper.mapDetail(expected);

    assertNotNull(result);
    assertNull(result.getId());
    assertNull(result.getName());
    assertNull(result.getDescription());
    assertNull(result.getType());
    assertNull(result.getGraduation());
    assertNotNull(result.getManufacturer());
  }

  @Test
  public void mapToDomainAggregator_whenNotNullParams_shouldExpectedValues() throws Exception {
    final BeverageEntity expected = new BeverageEntity(ID, NAME, DESCRIPTION, TYPE, GRADUATION, new ManufacturerEntity());

    mockMapManufacturer(new Manufacturer());
    final BeverageAggregate result = mapper.mapDetail(expected);

    assertNotNull(result);
    assertEquals(expected.getId(), result.getId());
    assertEquals(expected.getDescription(), result.getDescription());
    assertEquals(expected.getName(), result.getName());
    assertEquals(expected.getType(), result.getType());
    assertEquals(expected.getGraduation(), result.getGraduation());
    assertNotNull(result.getManufacturer());

  }

  @Test
  public void mapToDomainAggregator_whenNullGraduation_shouldExpectedValues() throws Exception {
    final BeverageEntity expected = new BeverageEntity(ID, NAME, DESCRIPTION, TYPE, null, new ManufacturerEntity());

    mockMapManufacturer(new Manufacturer());
    final BeverageAggregate result = mapper.mapDetail(expected);

    assertNotNull(result);
    assertEquals(expected.getId(), result.getId());
    assertEquals(expected.getDescription(), result.getDescription());
    assertEquals(expected.getName(), result.getName());
    assertEquals(expected.getType(), result.getType());
    assertNull(result.getGraduation());
    assertNotNull(result.getManufacturer());
  }

  @Test
  public void mapToDomainAggregator_whenNullType_shouldExpectedValues() throws Exception {
    final BeverageEntity expected = new BeverageEntity(ID, NAME, DESCRIPTION, null, GRADUATION, new ManufacturerEntity());

    mockMapManufacturer(new Manufacturer());
    final BeverageAggregate result = mapper.mapDetail(expected);

    assertNotNull(result);
    assertEquals(expected.getId(), result.getId());
    assertEquals(expected.getDescription(), result.getDescription());
    assertEquals(expected.getName(), result.getName());
    assertNull(result.getType());
    assertEquals(expected.getGraduation(), result.getGraduation());
    assertNotNull(result.getManufacturer());

  }

  @Test
  public void mapToDomainAggregator_whenNullName_shouldExpectedValues() throws Exception {
    final BeverageEntity expected = new BeverageEntity(ID, null, DESCRIPTION, TYPE, GRADUATION, new ManufacturerEntity());

    mockMapManufacturer(new Manufacturer());
    final BeverageAggregate result = mapper.mapDetail(expected);

    assertNotNull(result);
    assertEquals(expected.getId(), result.getId());
    assertEquals(expected.getDescription(), result.getDescription());
    assertNull(result.getName());
    assertEquals(expected.getType(), result.getType());
    assertEquals(expected.getGraduation(), result.getGraduation());
    assertNotNull(result.getManufacturer());

  }

  @Test
  public void mapToDomainAggregator_whenNullDescription_shouldExpectedValues() throws Exception {
    final BeverageEntity expected = new BeverageEntity(ID, NAME, null, TYPE, GRADUATION, new ManufacturerEntity());

    mockMapManufacturer(new Manufacturer());
    final BeverageAggregate result = mapper.mapDetail(expected);

    assertNotNull(result);
    assertEquals(expected.getId(), result.getId());
    assertEquals(expected.getName(), result.getName());
    assertNull(result.getDescription());
    assertEquals(expected.getType(), result.getType());
    assertEquals(expected.getGraduation(), result.getGraduation());
    assertNotNull(result.getManufacturer());

  }

  @Test
  public void mapToDomainAggregator_whenNullManufacturer_shouldExpectedValues() throws Exception {
    final BeverageEntity expected = new BeverageEntity(ID, NAME, DESCRIPTION, TYPE, GRADUATION, null);

    mockMapManufacturer(null);
    final BeverageAggregate result = mapper.mapDetail(expected);

    assertNotNull(result);
    assertEquals(expected.getId(), result.getId());
    assertEquals(expected.getName(), result.getName());
    assertEquals(expected.getDescription(), result.getDescription());
    assertEquals(expected.getType(), result.getType());
    assertEquals(expected.getGraduation(), result.getGraduation());
    assertNull(result.getManufacturer());
  }

  private void mockMapManufacturer(final Manufacturer values) {
    Mockito.when(manufacturerMapper.map(ArgumentMatchers.any(ManufacturerEntity.class))).thenReturn(values);
  }

  @Test
  public void mapToPersistence_whenNull_shouldReturnNull() {
    final BeverageEntity result = mapper.map((Beverage) null);

    assertNull(result);
  }

  @Test
  public void mapToPersistence_whenNullParams_shouldExpectedValues() throws Exception {
    final Beverage expected = new Beverage(null, null, null, null, null);

    final BeverageEntity result = mapper.map(expected);

    assertNotNull(result);
    assertNull(result.getId());
    assertNull(result.getName());
    assertNull(result.getDescription());
    assertNull(result.getType());
    assertNull(result.getGraduation());
  }

  @Test
  public void mapToPersistence_whenNotNullParams_shouldExpectedValues() throws Exception {
    final Beverage expected = new Beverage(ID, NAME, DESCRIPTION, TYPE, GRADUATION);

    final BeverageEntity result = mapper.map(expected);

    assertNotNull(result);
    assertEquals(expected.getId(), result.getId());
    assertEquals(expected.getDescription(), result.getDescription());
    assertEquals(expected.getName(), result.getName());
    assertEquals(expected.getType(), result.getType());
    assertEquals(expected.getGraduation(), result.getGraduation());
  }

  @Test
  public void mapToPersistence_whenNullGraduation_shouldExpectedValues() throws Exception {
    final Beverage expected = new Beverage(ID, NAME, DESCRIPTION, TYPE, null);

    final BeverageEntity result = mapper.map(expected);

    assertNotNull(result);
    assertEquals(expected.getId(), result.getId());
    assertEquals(expected.getDescription(), result.getDescription());
    assertEquals(expected.getName(), result.getName());
    assertEquals(expected.getType(), result.getType());
    assertNull(result.getGraduation());
  }

  @Test
  public void mapToPersistence_whenNullType_shouldExpectedValues() throws Exception {
    final Beverage expected = new Beverage(ID, NAME, DESCRIPTION, null, GRADUATION);

    final BeverageEntity result = mapper.map(expected);

    assertNotNull(result);
    assertEquals(expected.getId(), result.getId());
    assertEquals(expected.getDescription(), result.getDescription());
    assertEquals(expected.getName(), result.getName());
    assertNull(result.getType());
    assertEquals(expected.getGraduation(), result.getGraduation());
  }

  @Test
  public void mapToPersistence_whenNullName_shouldExpectedValues() throws Exception {
    final Beverage expected = new Beverage(ID, null, DESCRIPTION, TYPE, GRADUATION);

    final BeverageEntity result = mapper.map(expected);

    assertNotNull(result);
    assertEquals(expected.getId(), result.getId());
    assertEquals(expected.getDescription(), result.getDescription());
    assertNull(result.getName());
    assertEquals(expected.getType(), result.getType());
    assertEquals(expected.getGraduation(), result.getGraduation());
  }

  @Test
  public void mapToPersistence_whenNullDescription_shouldExpectedValues() throws Exception {
    final Beverage expected = new Beverage(ID, NAME, null, TYPE, GRADUATION);

    final BeverageEntity result = mapper.map(expected);

    assertNotNull(result);
    assertEquals(expected.getId(), result.getId());
    assertEquals(expected.getName(), result.getName());
    assertNull(result.getDescription());
    assertEquals(expected.getType(), result.getType());
    assertEquals(expected.getGraduation(), result.getGraduation());
  }
}