package com.geekbrains.HW6;

import com.geekbrains.HW7.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@Epic("Сайт для публикации своих записей")
public class DiaryTest {
    WebDriver driver;
    NewEntryPage newEntryPage;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        newEntryPage = new NewEntryPage(driver);
    }

    @Test
    @Feature("Новая запись")
    @Story("Добавление новой записи")
    @TmsLink("321")
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
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        for(LogEntry logEntry : logEntries) {
            Allure.addAttachment("Элемент лога браузера", logEntry.getMessage());
        }

        driver.quit();
    }
}
