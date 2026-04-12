package com.sergiotrapiello.cursotesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HelloWorldGettingStartedTest {

    @BeforeEach
    void setup() {
        System.out.println("before");
    }

    @Test
    void gettingStarted() {
        // fail("not implemented yet");
        System.out.println("gettingStarted");
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.greet();

        assertEquals("Hello World!", result);
    }

    @Test
    void test2() {
        System.out.println("test2");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after");
    }
}
