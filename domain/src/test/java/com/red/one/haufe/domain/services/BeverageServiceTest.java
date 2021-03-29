package com.red.one.haufe.domain.services;

import com.red.one.haufe.domain.entities.Beverage;
import com.red.one.haufe.domain.ports.BeveragePort;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class BeverageServiceTest {

  @Mock
  private BeveragePort port;

  @InjectMocks
  private BeverageService service;

  @Before
  public void onBefore() throws Exception {
    MockitoAnnotations.initMocks(this);
    setUp();
  }

  public void setUp() throws Exception {
    // Method implemented when required
  }

  @Test
  public void findAll_whenNotNull_shouldExpectedSize() {
    final Beverage[] expectedDomain = BeverageDataset.getBeers();
    int expectedSize = expectedDomain.length;
    List<Beverage> values = Arrays.asList(expectedDomain);
    mockFindAll(new PageImpl(values));

    final Page<Beverage> result = service.findAll(Pageable.unpaged());

    Assert.assertNotNull(result);
    Assert.assertTrue(result.getSize() == expectedSize);
  }

  @Test
  public void findAll_whenNull_shouldExpectedEmptyList() {
    mockFindAll(new PageImpl(Collections.emptyList()));

    final Page<Beverage> result = service.findAll(Pageable.unpaged());

    Assert.assertEquals(Collections.EMPTY_LIST, result.get().collect(Collectors.toList()));
  }

  @Test
  public void findAll_whenNotNull_shouldExpectedValues() {
    final Beverage[] expectedDomain = BeverageDataset.getBeers();
    List<Beverage> values = Arrays.asList(expectedDomain);
    mockFindAll(new PageImpl(values));

    final Page<Beverage> result = service.findAll(Pageable.unpaged());

    Assert.assertNotNull(result);
    final Optional<Beverage> first = result.get().findFirst();
    Assertions.assertTrue(first.isPresent());
    final Beverage beverage = first.get();
    Assert.assertEquals(expectedDomain[0].getId(), beverage.getId());
    Assert.assertEquals(expectedDomain[0].getDescription(), beverage.getDescription());
    Assert.assertEquals(expectedDomain[0].getName(), beverage.getName());
    Assert.assertEquals(expectedDomain[0].getGraduation(), beverage.getGraduation());
    Assert.assertEquals(expectedDomain[0].getType(), beverage.getType());
  }

  @Test
  public void findAll_whenNotNull_shouldCallOnceRepository() {
    final Beverage[] expectedDomain = BeverageDataset.getBeers();
    final List<Beverage> values = Arrays.asList(expectedDomain);
    mockFindAll(new PageImpl(values));
    final Pageable unpaged = Pageable.unpaged();

    final Page<Beverage> result = service.findAll(unpaged);

    Assert.assertNotNull(result);
    Mockito.verify(port, Mockito.only()).findAll(ArgumentMatchers.eq(unpaged));
  }

  private void mockFindAll(final Page<Beverage> values) {
    Mockito.when(port.findAll(Pageable.unpaged())).thenReturn(values);
  }
}