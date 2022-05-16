package com.geekbrains.HW5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class DiarysTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://diary.ru");
    }

    @Test
    void loginDiaryTest() {
        WebElement loginButton = driver.findElement(By.xpath("//a[.='Вход']"));
        loginButton.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Вход']")));
        driver.findElement(By.xpath("//a[.='Вход']")).click();

        driver.findElement(By.id("loginform-username")).sendKeys("PalladaV");
        driver.findElement(By.id("loginform-password")).sendKeys("123654");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@title='reCAPTCHA']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();

        driver.switchTo().parentFrame();

        driver.findElement(By.id("login_btn")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("login_btn")));
        Assertions.assertEquals(driver.findElement(By.id("login_btn")).isDisplayed(), true);

    }

    @Test
    void loginCookieDiaryTest() {
        Cookie authCookie = new Cookie("_identity_", "3070a2e5500c1522278ec9399fe1033523d8105ff24fc564be59f" +
                "f718c28f1caa%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3566570%2C%223KBriYXn" +
                "4V2lHSb11_GBMqGxKruy-YiA%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(authCookie);
        driver.navigate().refresh();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div//ul//li[@class=\"username\"]")));
        Assertions.assertEquals(driver.findElement(By.xpath("//div//ul//li[@class=\"username\"]")).isDisplayed(), true);
    }


    @Test
    void newEntryTest () {
        Cookie authCookie = new Cookie("_identity_", "3070a2e5500c1522278ec9399fe1033523d8105ff24fc564be59f" +
                "f718c28f1caa%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3566570%2C%223KBriYXn" +
                "4V2lHSb11_GBMqGxKruy-YiA%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(authCookie);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@title='Новая запись']")).click();
        String postName = "Post" + new Random().nextInt(1000);
        driver.findElement(By.id("postTitle")).sendKeys(postName);
        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.id("tinymce")).sendKeys("Our post test");
        driver.switchTo().parentFrame();
        driver.findElement(By.id("rewrite")).click();
        List<WebElement> posts = driver.findElements(By.xpath("//a[@class='title']"));
        posts.stream().filter(p -> p.getText().contains(postName)).findFirst().get().click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div//a[@class=\"TagJIco\"]")));
        Assertions.assertEquals(driver.findElement(By.xpath("//div//a[@class=\"TagJIco\"]")).isDisplayed(), true);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
