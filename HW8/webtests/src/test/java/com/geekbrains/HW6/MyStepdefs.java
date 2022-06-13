package com.geekbrains.HW6;

import com.codeborne.selenide.Selenide;
import com.geekbrains.HW8.LoginPage;
import com.geekbrains.HW8.MyAccountPage;
import com.geekbrains.HW8.MyDiaryPage;
import com.geekbrains.HW8.NewEntryPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Given("User authorized")
    public void userAuthorized() throws InterruptedException {
        open("https://diary.ru");
        new LoginPage().login("PalladaV", "123654");
    }

    @When("Click New Entry")
    public void clickNewEntry() {
        new MyAccountPage().navigationBlock.clickNewEntry();
    }

    @And("Add New Entry")
    public void addNewEntry() {
        new NewEntryPage().addNewEntry();
    }

    @Then("Check Correct Page")
    public void checkCorrectPage() {
        new MyDiaryPage().checkCorrectPage();
    }

    @After (value = "@close")
    public void quitBrowser () {
        Selenide.closeWebDriver();
    }
}
