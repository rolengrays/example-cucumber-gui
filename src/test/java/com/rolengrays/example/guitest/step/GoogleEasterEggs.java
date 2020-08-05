package com.rolengrays.example.guitest.step;

import com.codeborne.selenide.Condition;
import com.rolengrays.example.guitest.ScenarioContext;
import com.rolengrays.example.guitest.page.GoogleResultPage;
import io.cucumber.java.ja.ならば;
import io.cucumber.java.ja.もし;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class GoogleEasterEggs extends AbstractStep {

  public GoogleEasterEggs(ScenarioContext context) {
    super(context);
  }

  @もし("人生、宇宙、すべての答えを計算する")
  public void theAnswerToLifeTheUniverseAndEverything() {
    context.googleSearchPage.search("人生、宇宙、すべての答え");
  }

  @ならば("結果は42である")
  public void theAnswerIs42() {
    context.googleResultPage = page(GoogleResultPage.class);
    context.googleResultPage.getCalcResult().shouldBe(text("42"));
  }
}
