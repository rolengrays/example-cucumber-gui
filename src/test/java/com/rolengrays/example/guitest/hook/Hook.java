package com.rolengrays.example.guitest.hook;

import io.cucumber.java.*;
import com.rolengrays.example.guitest.ScenarioContext;

import static com.codeborne.selenide.Selenide.*;

public class Hook {
  private final ScenarioContext context;

  // ScenarioContextは、cucumber-picocontainerにより各シナリオごとにDIされる。
  public Hook(ScenarioContext context) {
    this.context = context;
  }

  // 各シナリオ実行前
  @Before
  public void beforeScenario() {
    clearBrowserCookies();
  }

  // 各シナリオ実行後
  @After
  public void afterScenario() {
    closeWebDriver();
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
