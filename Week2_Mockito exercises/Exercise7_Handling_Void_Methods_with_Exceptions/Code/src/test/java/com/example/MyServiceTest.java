package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVoidMethodThrowsException() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        doThrow(new RuntimeException("Mock exception")).when(mockApi).riskyOperation();

        assertThrows(RuntimeException.class, service::performOperation);

        verify(mockApi).riskyOperation();
    }
}
