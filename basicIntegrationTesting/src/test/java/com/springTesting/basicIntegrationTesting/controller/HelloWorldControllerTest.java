package com.springTesting.basicIntegrationTesting.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloWorld() throws Exception {
        RequestBuilder request= MockMvcRequestBuilders.get("/hello");
        MvcResult result=mockMvc.perform(request).andReturn();
        assertEquals("Hello World",result.getResponse().getContentAsString());
    }

    @Test
    void testHelloWithName() throws Exception{
        mockMvc.perform(get("/hello?name=Manish")).andExpect(content().string("Hello Manish"));
    }
}