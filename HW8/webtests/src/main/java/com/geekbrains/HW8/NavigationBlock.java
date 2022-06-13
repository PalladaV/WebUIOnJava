package com.geekbrains.HW8;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class NavigationBlock {

    private SelenideElement newEntry = $(By.xpath("//a[@title='Новая запись']"));


    @Step("Клик на кнопку Новая запись в навигационном блоке")
    public NewEntryPage clickNewEntry() {
        newEntry.hover();
        newEntry.click();
        return Selenide.page(NewEntryPage.class);
    }
}

