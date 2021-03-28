package com.red.one.haufe.controller;

import com.red.one.haufe.controller.mappers.BeverageDtoMapper;
import com.red.one.haufe.haufe.controller.mappers.BeverageDtoMapperImpl;
import com.red.one.haufe.domain.entities.Beverage;
import com.red.one.haufe.domain.services.BeverageService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

public class BeverageControllerTest extends BaseTest {

    @Mock
    private BeverageService service;

    @Spy
    private BeverageDtoMapper mapper = new BeverageDtoMapperImpl();

    @InjectMocks
    private BeverageController controller;

    /**@Test
    public void testGetTop5ByHeight_whenExistsData_shouldCallService() throws Exception {
        final Beverage[] expected = PokeDtoDataset.getSpecies();
        mockGetTop5ByHeight(Arrays.asList(expected));

        controller.getTop5ByHeight();

        Mockito.verify(this.service, Mockito.times(1))
                .getCurrentPrice();
        Mockito.verifyNoMoreInteractions(this.service);
    }

    @Test
    public void testGetTop5ByHeight_whenExistsData_shouldCallMapper() throws Exception {
        final Beverage[] expected = PokeDtoDataset.getSpecies();
        mockGetTop5ByHeight(Arrays.asList(expected));

        controller.getTop5ByHeight();

        Mockito.verify(this.mapper, Mockito.times(5))
                .map(Mockito.any(Beverage.class));
    }

    @Test
    public void testGetTop5ByHeight_whenExistsData_shouldExpectedValues() throws Exception {
        final Beverage[] expected = PokeDtoDataset.getSpecies();
        final List<Beverage> expectedList = Arrays.asList(expected);
        mockGetTop5ByHeight(expectedList);

        final List<BeverageDto> result = controller.getTop5ByHeight();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(expectedList.size(), result.size());
    }

    @Test
    public void testGetTop5ByHeight_whenEmpty_shouldCallExpectedValues() throws Exception {
        mockGetTop5ByHeight(Collections.EMPTY_LIST);

        final Mono<BeverageDto> result = controller.getTop5ByHeight(null, null, null);

        Assertions.assertEquals(Collections.EMPTY_LIST, result);
    }

    private void mockGetTop5ByHeight(final List<Beverage> expected) {
        //Mockito.when(service.getCurrentPrice()).thenReturn(expected);
    }

    //The same for other operations*/
}