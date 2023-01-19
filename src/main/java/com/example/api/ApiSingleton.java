package com.example.api;

import com.example.model.Demo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public enum ApiSingleton {

    INSTANCE;

    private final HttpRequestFactory requestFactory;

    ApiSingleton() { requestFactory = new NetHttpTransport().createRequestFactory();}


    public Demo postData(String body) {
        try {
            HttpRequest request = requestFactory.buildPostRequest(
                    new GenericUrl("https://jsonplaceholder.typicode.com/posts"), null );
            ObjectMapper objectMapper = new ObjectMapper();
            String requestResponse = request.execute().parseAsString();

            return objectMapper.readValue(requestResponse, Demo.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Demo putData(String body) {
        try {
            HttpRequest request = requestFactory.buildPutRequest(
                    new GenericUrl("https://jsonplaceholder.typicode.com/posts/1"), null );
            ObjectMapper objectMapper = new ObjectMapper();
            String requestResponse = request.execute().parseAsString();

            return objectMapper.readValue(requestResponse, Demo.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
