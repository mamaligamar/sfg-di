package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import guru.springframework.sfgdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstructorInjectedControllerTest {

    private ConstructorInjectedController controller;
    private GreetingService service;
    @BeforeEach
    void setUp(){
        service = new ConstructorGreetingService();
        controller = new ConstructorInjectedController(service);
    }
    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}