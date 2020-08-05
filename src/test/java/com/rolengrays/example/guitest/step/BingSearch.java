package com.rolengrays.example.guitest.step;

import com.codeborne.selenide.CollectionCondition;
import com.rolengrays.example.guitest.ScenarioContext;
import com.rolengrays.example.guitest.page.BingResultPage;
import com.rolengrays.example.guitest.page.BingSearchPage;
import com.rolengrays.example.guitest.page.GoogleResultPage;
import io.cucumber.java.ja.かつ;
import io.cucumber.java.ja.もし;
import io.cucumber.java.ja.前提;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class BingSearch extends AbstractStep {

  public BingSearch(ScenarioContext context) {
    super(context);
  }

  @前提("Bing検索ページを開く")
  public void openSearchPage() {
    context.bingSearchPage = open("https://www.bing.com/", BingSearchPage.class);
  }

  @もし("Bing検索ページに{string}を入力して検索する")
  public void inputSearchWords(String word) {
    context.bingSearchPage.search(word);
  }

  @かつ("Bing検索結果が表示される")
  public void getResult() {
    context.bingResultPage = page(BingResultPage.class);
    context.bingResultPage.getResults().shouldBe(sizeGreaterThanOrEqual(1));
    context.bingResults = context.bingResultPage.getResults().texts();
  }
}
