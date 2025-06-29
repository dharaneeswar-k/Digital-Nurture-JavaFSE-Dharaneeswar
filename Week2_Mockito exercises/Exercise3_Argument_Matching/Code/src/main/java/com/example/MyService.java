package com.example;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void processAndSend(String input) {
        String processed = "Processed: " + input;
        api.sendData(processed);
    }
}
