package com.geekbrains.HW8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;


public class MyDiaryPage {

    private SelenideElement nicknameElement = $(By.xpath("//div//a[@class=\"TagL\" and \"PalladaV\"]"));

    @Step("Проверка отображения элемента никнейм")
    public void checkCorrectPage() {
        Assertions.assertAll(
                () -> nicknameElement.shouldBe(visible));
    }
}
