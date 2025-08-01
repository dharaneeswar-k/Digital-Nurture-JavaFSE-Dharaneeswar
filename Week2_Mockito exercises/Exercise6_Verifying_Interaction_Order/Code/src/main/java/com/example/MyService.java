package com.example;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void useApi() {
        api.connect();
        api.fetchData();
        api.disconnect();
    }
}
