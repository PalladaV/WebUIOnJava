package com.geekbrains.HW6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationBlock extends BaseView {
    public NavigationBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Новая запись']")
    private WebElement newEntry;


    @Step("Клик на кнопку Новая запись в навигационном блоке")
    public NewEntryPage clickNewEntry() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(newEntry));
        newEntry.click();
        return new NewEntryPage(driver);
    }
}

