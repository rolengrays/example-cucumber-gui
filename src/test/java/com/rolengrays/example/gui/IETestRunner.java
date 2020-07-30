package com.rolengrays.example.gui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:results/gui/ie/result.html"},
        features = {"src/test/resources/com/rolengrays/example/gui/feature"},
        glue = {"com.rolengrays.example.gui.stepdef", "com.rolengrays.example.gui.hook"}
)
public class IETestRunner extends AbstractGuiTestRunner {
  @BeforeClass
  public static void beforeTest() {
    configureSelenide();
    Configuration.browser = WebDriverRunner.IE;
    Configuration.reportsFolder = "results/gui/ie/resource";
    Configuration.downloadsFolder = "results/gui/ie/resource";
    logger.info("Internet Exploreでテストを開始します。");
  }
}