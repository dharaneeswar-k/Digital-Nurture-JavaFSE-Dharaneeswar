package com.example;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void process() {
        // Does something and logs a message
        api.log("Processing completed");
    }
}
