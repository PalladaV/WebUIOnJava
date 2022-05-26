package com.geekbrains.HW6;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseView {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final static String RECAPTCHA_XPATH_LOCATOR = "'//iframe[@title='reCAPTCHA']";

    @FindBy(xpath = "//a[.='Вход']")
    public WebElement entryButton;

    @FindBy(id = "loginform-username")
    public WebElement usernameField;

    @FindBy(id = "loginform-password")
    public WebElement passwordField;

    @FindBy(xpath = RECAPTCHA_XPATH_LOCATOR)
    public WebElement reCaptcha;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    public WebElement recaptchaCheckboxBorder;

    @FindBy(id = "login_btn")
    public WebElement loginButton;

    @Step("Логинимся на сайте")
    public MyAccountPage login(String username, String password) {
        entryButton.click();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RECAPTCHA_XPATH_LOCATOR)));
        driver.switchTo().frame(driver.findElement(By.xpath(RECAPTCHA_XPATH_LOCATOR)));
        recaptchaCheckboxBorder.click();
        loginButton.click();
        return new MyAccountPage(driver);
    }
}
