package com.rolengrays.example.guitest;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
// https://javadoc.io/doc/io.cucumber/cucumber-junit/latest/io/cucumber/junit/CucumberOptions.html
// https://javadoc.io/doc/io.cucumber/cucumber-core/latest/io/cucumber/core/options/Constants.html
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/ie/ie-reports.html"},
        features = {"classpath:com/rolengrays/example/guitest/features"},
        glue = {"com.rolengrays.example.guitest.step", "com.rolengrays.example.guitest.hook"}
)
public class IETest extends AbstractTest {
  private static final String IE_WDM_PROPERTIES = "ie.wdm.properties";

  @BeforeClass
  public static void beforeTest() {
    Configuration.browser = Browsers.IE;
    addSystemPropertiesFromFile(WDM_PROPERTIES);
    // IEのみ、追加のWebDriverManager設定をロードする
    addSystemPropertiesFromFile(IE_WDM_PROPERTIES);
    loadSelenideConfigFromFile(Browsers.IE + ".properties");


    logger.info(String.format("%sでテストを開始します。", Browsers.IE));
  }
}
