package com.rolengrays.example.gui.page;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ja.もし;
import org.openqa.selenium.By;

public class GoogleSearchPage {
    public void search(String word) {
        $(By.name("q")).setValue(word).pressEnter();
    }
}
