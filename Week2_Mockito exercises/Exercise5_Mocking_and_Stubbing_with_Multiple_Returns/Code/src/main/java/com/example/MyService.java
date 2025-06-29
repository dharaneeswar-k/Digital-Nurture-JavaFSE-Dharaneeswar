package com.example;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchDataMultipleTimes() {
        String first = externalApi.getData();
        String second = externalApi.getData();
        return first + " | " + second;
    }
}
