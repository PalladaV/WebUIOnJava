package com.geekbrains;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.pkcs11.wrapper.Functions;

import static com.geekbrains.HW4.TriangleArea.calculateArea;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger("TriangleTest");

    @BeforeAll
    static void beforeAll() {
        System.out.println("Метод выполнится 1 раз перед всеми тестами");
        logger.info("info log");
        logger.warn("warn log");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Метод выполнится перед каждым тестами");
    }

    @Test
    @DisplayName("Позитивный тест площади треугольника")
    void givenTriangleAreaWhencalculateAreaThenTrue() throws Exception {
        double result = calculateArea(3, 4, 4);
        assertArrayEquals(result);
    }

    private void assertArrayEquals(double result) {
    }

    @AfterEach
    void afterEach() { System.out.println("Метод выполнится 1 раз после каждого теста");
    }

    @AfterAll
    static void afterAll() { System.out.println("Метод выполнится 1 раз после всех тестов");
    }

}
