package com.rolengrays.example.guitest.page;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;

public class BingResultPage {
  public ElementsCollection getResults() {
    return $$(".b_algo h2 a");
  }
}
