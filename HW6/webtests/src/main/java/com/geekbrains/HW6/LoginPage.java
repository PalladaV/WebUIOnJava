package com.geekbrains.HW6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "loginform-username")
    public WebElement usernameField;

    @FindBy(id = "loginform-password")
    public WebElement passwordField;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border")
    public WebElement recaptchaCheckboxBorder;

    @FindBy(id = "login_btn")
    public WebElement loginButton;

    public MyAccountPage login(String email, String password) {
        usernameField.sendKeys(email);
        passwordField.sendKeys(password);
        recaptchaCheckboxBorder.click();
        loginButton.click();
        return new MyAccountPage(driver);
    }
}
