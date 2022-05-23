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
        System.out.println("����� ���������� 1 ��� ����� ����� �������");
        logger.info("info log");
        logger.warn("warn log");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("����� ���������� ����� ������ �������");
    }

    @Test
    @DisplayName("���������� ���� ������� ������������")
    void givenTriangleAreaWhencalculateAreaThenTrue() throws Exception {
        double result = calculateArea(3, 4, 4);
        assertArrayEquals(result);
    }

    private void assertArrayEquals(double result) {
    }

    @AfterEach
    void afterEach() { System.out.println("����� ���������� 1 ��� ����� ������� �����");
    }

    @AfterAll
    static void afterAll() { System.out.println("����� ���������� 1 ��� ����� ���� ������");
    }

}
