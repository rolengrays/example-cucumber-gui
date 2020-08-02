package com.rolengrays.example.guitest.page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BingSearchPage {
  public void search(String word) {
    $("#sb_form_q").setValue(word).pressEnter();
  }
}
