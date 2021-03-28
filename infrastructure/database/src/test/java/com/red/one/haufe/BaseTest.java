package com.red.one.haufe;

import java.lang.reflect.Field;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

public abstract class BaseTest {

  @Before
  public void onBefore() throws Exception {
    MockitoAnnotations.initMocks(this);
    setUp();
  }

  protected void setUp() throws Exception {
    // Method implemented when required
  }

  private <T, S> void setField(final Class objectClass, final T object, final String key, final S value)
      throws Exception {
    final Field field = objectClass.getDeclaredField(key);
    field.setAccessible(true);
    field.set(object, value);
  }

  protected <T, S> void setField(final T object, final String key, final S value) throws Exception {
    setField(object.getClass(), object, key, value);
  }
}
