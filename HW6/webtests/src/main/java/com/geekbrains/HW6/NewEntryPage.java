package com.geekbrains.HW6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class NewEntryPage extends BaseView {
    public NewEntryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "postTitle")
    private WebElement postName;

    @FindBy(id = "message_ifr")
    private WebElement newMessageWindow;

    @FindBy(id = "tinymce")
    private WebElement newMessage;

    @FindBy(id = "rewrite")
    private WebElement rewriteButton;

    @FindBy(xpath = "//a[@class='title']")
    private List<WebElement> myPost;

    public MyDiaryPage addNewEntry() {
        String postName = "Post" + new Random().nextInt(1000);
        myPost.stream().filter(p -> p.getText().contains(postName)).findFirst().get().click();
        rewriteButton.click();
        return new MyDiaryPage(driver);
    }
}

