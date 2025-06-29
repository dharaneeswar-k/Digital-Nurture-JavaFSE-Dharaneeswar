package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testSendDataWithArgumentMatcher() {
        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);

        service.processAndSend("Hello");

        verify(mockApi).sendData(eq("Processed: Hello"));
    }
}
