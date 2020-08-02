package com.rolengrays.example.guitest.page;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;

public class GoogleSearchPage {
  public void search(String word) {
    $(By.name("q")).setValue(word).pressEnter();
  }
}
