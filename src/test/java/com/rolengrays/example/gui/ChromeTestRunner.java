package com.rolengrays.example.gui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:results/gui/chrome/result.html"},
        features = {"src/test/resources/com/rolengrays/example/gui/feature"},
        glue = {"com.rolengrays.example.gui.stepdef", "com.rolengrays.example.gui.hook"}
)
public class ChromeTestRunner extends AbstractGuiTestRunner {
  @BeforeClass
  public static void beforeTest() {
    configureSelenide();
    Configuration.browser = WebDriverRunner.CHROME;
    Configuration.reportsFolder = "results/gui/chrome/resource";
    Configuration.downloadsFolder = "results/gui/chrome/resource";
    logger.info("GoogleChromeでテストを開始します。");
  }
}
