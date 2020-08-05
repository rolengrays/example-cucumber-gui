package com.rolengrays.example.guitest.step;

import com.rolengrays.example.guitest.page.GoogleSearchPage;
import com.rolengrays.example.guitest.ScenarioContext;
import com.rolengrays.example.guitest.page.GoogleResultPage;
import io.cucumber.java.ja.かつ;
import io.cucumber.java.ja.ならば;
import io.cucumber.java.ja.もし;
import io.cucumber.java.ja.前提;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static org.assertj.core.api.Assertions.assertThat;

public class GoogleSearch extends AbstractStep {

  public GoogleSearch(ScenarioContext context) {
    super(context);
  }

  @前提("Google検索ページを開く")
  public void openSearchPage() {
    context.googleSearchPage = open("https://www.google.com/", GoogleSearchPage.class);
  }

  @もし("Google検索ページに{string}を入力して検索する")
  public void inputSearchWords(String word) {
    context.googleSearchPage.search(word);
  }

  @かつ("Google検索結果が表示される")
  public void getResult() throws InterruptedException {
    context.googleResultPage = page(GoogleResultPage.class);
    // 検索結果リストが存在する（サイズが1以上）ことを確認する。確認できるまでorタイムアウト経過まで待機する。
    context.googleResultPage.getResults().shouldBe(sizeGreaterThanOrEqual(1));
    // 検索結果リストのテキスト部分を抽出し、ほかのステップから参照できるようにする。
    context.googleResults = context.googleResultPage.getResults().texts();
  }

  @ならば("Google検索結果に{string}がヒットする")
  public void isHit(String title) {
    assertThat(context.googleResults).contains(title);
  }
}
