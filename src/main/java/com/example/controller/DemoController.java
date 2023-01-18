package com.example.controller;

import com.example.model.Demo;
import com.example.service.DemoService;
import io.micronaut.http.annotation.*;

import java.io.IOException;

@Controller("/demo")
public class DemoController {
    private DemoService demoService = new DemoService();

    @Post(uri="/post", produces="application/json")
    public Demo post(@Body String body) {
        return this.demoService.post(body);
    }


    @Put(uri="/put", produces="application/json")
    public Demo put(@Body String body) {
        return this.demoService.update(body);
    }
}