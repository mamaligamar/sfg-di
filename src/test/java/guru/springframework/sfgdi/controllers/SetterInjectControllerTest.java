package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectControllerTest {

    private SetterInjectController setterInjectController;

    @BeforeEach
    void setUp(){
        setterInjectController = new SetterInjectController();
        setterInjectController.setGreetingService(new ConstructorGreetingService());
    }
    @Test
    void getGreeting() {
        System.out.println(setterInjectController.getGreeting());
    }
}