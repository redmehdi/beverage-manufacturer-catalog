package com.red.one.haufe.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.red.one.haufe.BaseTest;
import com.red.one.haufe.BeverageDataset;
import com.red.one.haufe.domain.entities.Beverage;
import com.red.one.haufe.entities.BeverageEntity;
import com.red.one.haufe.mappers.BeverageMapper;
import com.red.one.haufe.mappers.BeverageMapperImpl;
import com.red.one.haufe.mappers.ManufacturerMapper;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BeverageAdapterTest extends BaseTest {

  @Mock
  private BeverageRepository repository;

  @InjectMocks
  private BeverageAdapter port;

  private BeverageMapper mapper = new BeverageMapperImpl();

  @Mock
  private ManufacturerMapper manufacturerMapper;

  @Override
  protected void setUp() throws Exception {
    setField(mapper, "manufacturerMapper", manufacturerMapper);
    super.setUp();
  }

  @Test
  public void findAll_whenNotNull_shouldExpectedSize() {
    final BeverageEntity[] expectedEntities = BeverageDataset.getBeersEntity();
    int expectedSize = expectedEntities.length;
    List<BeverageEntity> values = Arrays.asList(expectedEntities);
    mockFindAll(values);

    final Page<Beverage> result = port.findAll(Pageable.unpaged());

    assertNotNull(result);
    assertEquals(expectedSize, result.getSize());
  }

  @Test
  public void findAll_whenNotNull_shouldCallOnceRepository() {
    final BeverageEntity[] expectedEntities = BeverageDataset.getBeersEntity();
    List<BeverageEntity> values = Arrays.asList(expectedEntities);
    mockFindAll(values);

    final Page<Beverage> result = port.findAll(Pageable.unpaged());

    assertNotNull(result);
    Mockito.verify(repository, Mockito.times(1)).findAll();
  }

  @Test
  public void findAll_whenEmpty_shouldExpectedValues() {
    mockFindAll(Collections.emptyList());

    final Page<Beverage> result = port.findAll(Pageable.unpaged());

    assertNull(result);
  }

  private void mockFindAll(final List<BeverageEntity> values) {
    Mockito.when(repository.findAll()).thenReturn(values);

  }
}