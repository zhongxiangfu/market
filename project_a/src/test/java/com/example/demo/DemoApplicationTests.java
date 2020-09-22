package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    private String str;

    @Test
    void contextLoads() {
        List list = new ArrayList();
        System.out.println();
        System.out.println("list = " + list);

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

        }
    }

}
