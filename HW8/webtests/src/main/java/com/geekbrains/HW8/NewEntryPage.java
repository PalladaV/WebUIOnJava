package com.geekbrains.HW8;

import io.qameta.allure.Step;

import java.util.Random;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


public class NewEntryPage {

    private SelenideElement postName = $(By.id("postTitle"));

    private SelenideElement newMessageWindow = $(By.id("message_ifr"));

    private SelenideElement newMessage = $(By.id("tinymce"));

    private SelenideElement rewriteButton = $(By.id("rewrite"));

    private ElementsCollection myPost = $$(By.xpath("//a[@class='title']"));


    @Step("Добавление нового поста")
    public com.geekbrains.HW8.MyDiaryPage addNewEntry() {
        String postName = "Post" + new Random().nextInt(1000);
        myPost.stream().filter(p -> p.getText().contains(postName)).findFirst().get().click();
        rewriteButton.click();
        return page (MyDiaryPage.class);
    }

    public void setMyPost(ElementsCollection myPost) {
        this.myPost = myPost;
    }
}

