package com.geekbrains.HW8;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private SelenideElement entryButton = $(By.xpath("//a[.='Вход']"));

    private SelenideElement usernameField = $(By.id("loginform-username"));

    private SelenideElement passwordField = $(By.id("loginform-password"));

    private SelenideElement reCaptcha= $(By.xpath("//iframe[@title='reCAPTCHA']"));

    private SelenideElement recaptchaCheckboxBorder= $(By.xpath("//div[@class='recaptcha-checkbox-border']"));

    private SelenideElement loginButton = $(By.id("loginButton"));

    @Step("Логинимся на сайте")
    public MyAccountPage login(String username, String password) throws InterruptedException {
        entryButton.click();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        reCaptcha.wait();
        switchTo(recaptchaCheckboxBorder);
        recaptchaCheckboxBorder.click();
        loginButton.click();
        return page(MyAccountPage.class);
    }

    private void switchTo(SelenideElement recaptchaCheckboxBorder) {
    }
}
