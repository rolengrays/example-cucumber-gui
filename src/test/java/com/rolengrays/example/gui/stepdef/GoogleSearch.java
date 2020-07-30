package com.rolengrays.example.gui.stepdef;

import com.codeborne.selenide.Selenide;
import com.rolengrays.example.gui.page.GoogleSearchPage;
import com.rolengrays.example.gui.ScenarioContext;
import com.rolengrays.example.gui.page.GoogleResultPage;
import io.cucumber.java.ja.かつ;
import io.cucumber.java.ja.ならば;
import io.cucumber.java.ja.もし;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearch {
    private final ScenarioContext context;

    public GoogleSearch(ScenarioContext context) {
        this.context = context;
    }

    @もし("Googleを開く")
    public void openBrowser() {
        context.googleSearchPage = Selenide.open("https://www.google.com/", GoogleSearchPage.class);
    }

    @かつ("{string}を入力して検索する")
    public void inputWords(String word) {
        context.googleSearchPage.search(word);
    }

    @ならば("{string}がヒットする")
    public void isHit(String title) {
        context.googleResultPage = page(GoogleResultPage.class);
        context.googleResultPage.getResults().shouldBe(anyMatch("include",elm -> elm.getText().equals(title)));
    }
}
