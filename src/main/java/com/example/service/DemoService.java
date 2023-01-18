package com.example.service;

import com.example.api.ApiSingleton;
import com.example.model.Demo;

public class DemoService {

    public Demo post(String body) {
        return ApiSingleton.INSTANCE.postData(body);
    }

    public Demo update(String body) {
        return ApiSingleton.INSTANCE.putData(body);
    }

}
