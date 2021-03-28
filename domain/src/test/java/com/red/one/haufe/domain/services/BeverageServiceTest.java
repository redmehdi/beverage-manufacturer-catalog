package com.red.one.haufe.domain.services;

import com.red.one.haufe.domain.ports.BeveragePort;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
    /**
    @Test
    public void findTop5ByHeight_whenNotNull_shouldExpectedSize() {
        final Beverage[] expectedDomain = PokeDataset.getSpecies();
        int expectedSize = expectedDomain.length;
        List<Beverage> values = Arrays.asList(expectedDomain);
        mockFindTop5ByHeight(values);

        final List<Beverage> result = service.getCurrentPrice();

        Assertions.assertNotNull(result);
        Assert.assertTrue(result.size() == expectedSize);
    }

    private void mockFindTop5ByHeight(final List<Beverage> values) {
        Mockito.when(port.findPrice()).thenReturn(values);
    }

    private void mockFindTop5ByHeight(final RuntimeException values) {
        Mockito.when(port.findPrice()).thenThrow(values);
    }

    @Test
    public void findTop5ByHeight_whenNotNull_shouldExpectedValues() {
        final Beverage[] expectedDomain = PokeDataset.getSpecies();
        List<Beverage> values = Arrays.asList(expectedDomain);
        mockFindTop5ByHeight(values);

        final List<Beverage> result = service.getCurrentPrice();

        Assertions.assertNotNull(result);
        Beverage pricing = result.get(0);
        Assert.assertEquals(expectedDomain[0].getId(), pricing.getId());
        Assert.assertEquals(expectedDomain[0].getColor(), pricing.getColor());
        Assert.assertEquals(expectedDomain[0].getName(), pricing.getName());
    }

    @Test
    public void findTop5ByHeight_whenNull_shouldExpectedEmptyList() {
        mockFindTop5ByHeight(Collections.EMPTY_LIST);

        final List<Beverage> result = service.getCurrentPrice();

        Assertions.assertEquals(Collections.EMPTY_LIST, result);
    }

    @Test
    public void findTop5ByHeight_whenNotNull_shouldCallOnceRepository() {
        final Beverage[] expectedDomain = PokeDataset.getSpecies();
        List<Beverage> values = Arrays.asList(expectedDomain);
        mockFindTop5ByHeight(values);

        final List<Beverage> result = service.getCurrentPrice();

        Assertions.assertNotNull(result);
        Mockito.verify(port, Mockito.times(1)).findPrice();
        Mockito.verify(port, Mockito.never()).findTop5ByWeight();
        Mockito.verify(port, Mockito.never()).findTop5ByBaseExperience();
    }

    @Test(expected = RuntimeException.class)
    public void findTop5ByHeight_whenNotNull_shouldExpectedException() {
        mockFindTop5ByHeight(new RuntimeException());

        service.getCurrentPrice();
    }

    //The same unit test for findTop5ByWeight and findTop5ByBaseExperience*/
}