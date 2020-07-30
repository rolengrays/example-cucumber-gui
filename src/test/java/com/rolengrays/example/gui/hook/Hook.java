package com.rolengrays.example.gui.hook;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hook {
  // 各シナリオ実行前
  @Before
  public void beforeScenario() {
    Selenide.clearBrowserCookies();
  }

  // 各シナリオ実行後
  @After
  public void afterScenario() {

  }

  // 各ステップ実行前
  @BeforeStep
  public void beforeStep() {

  }

  // 各ステップ実行後
  @AfterStep
  public void afterStep() {

  }
}
