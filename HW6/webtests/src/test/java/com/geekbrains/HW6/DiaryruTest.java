package com.geekbrains.HW6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DiaryruTest {
    WebDriver driver;
    NewEntryPage newEntryPage;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        newEntryPage = new NewEntryPage(driver);
    }

    @Test
    void addNewEntry() throws InterruptedException {
        driver.get("https://diary.ru");
        new LoginPage(driver)
                .login("PalladaV", "123654")
                .navigationBlock
                .clickNewEntry()
                .addNewEntry().
                checkCorrectPage();

        Assertions.assertAll(
                () -> Assertions.assertTrue(new MyDiaryPage (driver).nicknameElement.isDisplayed())
        );

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
