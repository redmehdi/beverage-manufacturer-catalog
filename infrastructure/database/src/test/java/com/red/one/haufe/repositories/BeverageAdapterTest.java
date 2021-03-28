package com.red.one.haufe.repositories;

import com.red.one.haufe.domain.entities.Beverage;
import com.red.one.haufe.mappers.BeverageMapper;
import com.red.one.haufe.mappers.BeverageMapperImpl;
import org.junit.Before;
import org.mockito.*;

public class BeverageAdapterTest {
    @Mock
    private BeverageRepository repository;

    @Spy
    private BeverageMapper mapper = new BeverageMapperImpl();

    @InjectMocks
    private BeverageAdapter port;

    @Before
    public void onBefore() throws Exception {
        MockitoAnnotations.initMocks(this);
        setUp();
    }

    public void setUp() throws Exception {
        // Method implemented when required
    }

   /** @Test
    public void findTop5ByHeight_whenNotNull_shouldExpectedSize() {
        final BeverageEntity[] expectedEntities = BeverageDataset.getSpeciesEntity();
        int expectedSize = expectedEntities.length;
        List<BeverageEntity> values = Arrays.asList(expectedEntities);
        mockFindTop5ByHeight(values);

        final List<Beverage> result = port.findPrice();

        Assertions.assertNotNull(result);
        Assert.assertTrue(result.size() == expectedSize);
    }

    @Test
    public void findTop5ByHeight_whenNotNull_shouldExpectedValues() {
        final BeverageEntity[] expectedEntities = BeverageDataset.getSpeciesEntity();
        List<BeverageEntity> values = Arrays.asList(expectedEntities);
        mockFindTop5ByHeight(values);

        final List<Beverage> result = port.findPrice();

        Assertions.assertNotNull(result);
        Beverage pricing = result.get(0);
        Assert.assertNull(pricing.getId());
    }

    @Test
    public void findTop5ByHeight_whenNull_shouldExpectedEmptyList() {
        mockFindTop5ByHeight(Collections.EMPTY_LIST);

        final List<Beverage> result = port.findPrice();

        Assertions.assertEquals(Collections.EMPTY_LIST, result);
    }

    @Test
    public void findTop5ByHeight_whenNotNull_shouldCallOnceRepository() {
        final BeverageEntity[] expectedEntities = BeverageDataset.getSpeciesEntity();
        List<BeverageEntity> values = Arrays.asList(expectedEntities);
        mockFindTop5ByHeight(values);

        final List<Beverage> result = port.findPrice();

        Assertions.assertNotNull(result);
        Mockito.verify(repository, Mockito.times(1)).findPrice();
       // Mockito.verify(repository, Mockito.never()).findTop5ByWeight();
        //Mockito.verify(repository, Mockito.never()).findTop5ByBaseExperience();
    }

    @Test(expected = RuntimeException.class)
    public void findTop5ByHeight_whenNotNull_shouldExpectedException() {
        mockFindTop5ByHeight(new RuntimeException());

        port.findPrice();
    }

    @Test
    public void findTop5ByHeight_whenNotNull_shouldCall5TimesMapper() {
        final BeverageEntity[] expectedEntities = BeverageDataset.getSpeciesEntity();
        final int expectedSize = expectedEntities.length;
        List<BeverageEntity> values = Arrays.asList(expectedEntities);
        mockFindTop5ByHeight(values);

        final List<Beverage> result = port.findPrice();

        Assertions.assertNotNull(result);
        Mockito.verify(mapper, Mockito.times(expectedSize)).map(Mockito.any(BeverageEntity.class));
        //Mockito.verify(repository, Mockito.never()).findTop5ByWeight();
        // Mockito.verify(repository, Mockito.never()).findTop5ByBaseExperience();
    }


    private void mockFindTop5ByHeight(final List<BeverageEntity> values) {
        Mockito.when(repository.findPrice()).thenReturn(values);
    }

    private void mockFindTop5ByHeight(final RuntimeException values) {
        Mockito.when(repository.findPrice()).thenThrow(values);
    }*/

}