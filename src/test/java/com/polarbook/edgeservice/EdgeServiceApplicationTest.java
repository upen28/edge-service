package com.polarbook.edgeservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EdgeServiceApplicationTest {
    @Autowired
    private EdgeServiceApplication application;

    @Test
    void testApplicationContext() {
        assertNotNull(application);
    }
}
