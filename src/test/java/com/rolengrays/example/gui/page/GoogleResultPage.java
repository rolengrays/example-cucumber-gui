package com.rolengrays.example.gui.page;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleResultPage {
  public ElementsCollection getResults() {
    return $$("h3.LC20lb.DKV0Md");
  }
}
