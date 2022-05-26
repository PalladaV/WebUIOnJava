package com.geekbrains.HW6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;



public class MyDiaryPage extends BaseView {
    public MyDiaryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div//a[@class=\"TagL\" and \"PalladaV\"]")
    public WebElement nicknameElement;


    @Step("Проверка отображения элемента никнейм")
    public void checkCorrectPage() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div//a[@class=\"TagL\" and \"PalladaV\"]")));
        Assertions.assertAll(
                () -> Assertions.assertTrue(new MyDiaryPage (driver).nicknameElement.isDisplayed())
        );
    }
}
