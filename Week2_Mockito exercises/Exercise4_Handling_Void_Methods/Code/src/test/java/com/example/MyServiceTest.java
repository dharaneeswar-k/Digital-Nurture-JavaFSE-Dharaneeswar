package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVoidMethodInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);

        doNothing().when(mockApi).log("Processing completed");

        MyService service = new MyService(mockApi);
        service.process();

        verify(mockApi).log("Processing completed");
    }
}
