package com.rolengrays.example.guitest.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class GoogleResultPage {
  public ElementsCollection getResults() {
    return $$("h3.LC20lb.DKV0Md");
  }

  public SelenideElement getCalcResult() {
    return $("#cwos");
  }
}
