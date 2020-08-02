package com.rolengrays.example.guitest;

import com.codeborne.selenide.ElementsCollection;
import com.rolengrays.example.guitest.page.BingResultPage;
import com.rolengrays.example.guitest.page.BingSearchPage;
import com.rolengrays.example.guitest.page.GoogleSearchPage;
import com.rolengrays.example.guitest.page.GoogleResultPage;

import java.util.List;

public class ScenarioContext {
  public GoogleSearchPage googleSearchPage;
  public GoogleResultPage googleResultPage;

  public BingSearchPage bingSearchPage;
  public BingResultPage bingResultPage;

  public List<String> googleResults;
  public List<String> bingResults;
}
