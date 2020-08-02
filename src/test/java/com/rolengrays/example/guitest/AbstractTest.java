package com.rolengrays.example.guitest;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.SelectorMode;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.Properties;

abstract public class AbstractTest {
  protected final static Logger logger;
  private final static String PROPERTIES_FOLDER = "properties";
  protected final static String WEBDRIVERMANAGER_PROPERTIES = "webdrivermanager.properties";

  static {
    logger = Logger.getLogger(AbstractTest.class.toString());
  }

  protected static void addSystemPropertiesFromFile(String filename) {
    Properties prop = Objects.requireNonNull(getPropertiesFromFile(filename));
    prop.forEach((key,value) -> System.setProperty((String)key,(String)value));
  }

  protected static void loadSelenideConfigFromFile(String filename) {
    Properties prop = Objects.requireNonNull(getPropertiesFromFile(filename));
    configureSelenide(prop);
  }

  private static Properties getPropertiesFromFile(String filename) {
    String propertiesFilePath = FileSystems.getDefault().getPath(PROPERTIES_FOLDER, filename).toString();
    try (InputStream is = AbstractTest.class.getResourceAsStream(propertiesFilePath)) {
      Properties prop = new Properties();
      prop.load(is);
      logger.info(String.format("プロパティファイル'%s'の読み込みに成功しました。", filename));
      return prop;
    } catch (IOException e) {
      e.printStackTrace();
      logger.warning(String.format("プロパティファイル'%s'の読み込みに失敗しました。", filename));
      return null;
    }
  }

  private static void configureSelenide(Properties prop) {
    Configuration.reportsFolder = prop.getProperty("selenide.reportsFolder");
    Configuration.downloadsFolder = prop.getProperty("selenide.downloadsFolder");
    Configuration.timeout = Long.parseLong(prop.getProperty("selenide.timeout"));
    Configuration.pollingInterval = Long.parseLong(prop.getProperty("selenide.pollingInterval"));
    Configuration.holdBrowserOpen = Boolean.parseBoolean(prop.getProperty("selenide.holdBrowserOpen"));
    Configuration.reopenBrowserOnFail=Boolean.parseBoolean(prop.getProperty("selenide.reopenBrowserOnFail"));
    Configuration.browserSize = prop.getProperty("selenide.browserSize");
    Configuration.browserPosition = prop.getProperty("selenide.browserPosition");
    Configuration.startMaximized = Boolean.parseBoolean(prop.getProperty("selenide.startMaximized"));
    Configuration.pageLoadStrategy = prop.getProperty("selenide.pageLoadStrategy");
    Configuration.clickViaJs = Boolean.parseBoolean(prop.getProperty("selenide.clickViaJs"));
    Configuration.screenshots = Boolean.parseBoolean(prop.getProperty("selenide.screenshots"));
    Configuration.savePageSource = Boolean.parseBoolean(prop.getProperty("selenide.savePageSource"));
    Configuration.fastSetValue = Boolean.parseBoolean(prop.getProperty("selenide.fastSetValue"));
    Configuration.versatileSetValue = Boolean.parseBoolean(prop.getProperty("selenide.versatileSetValue"));
    Configuration.selectorMode = SelectorMode.valueOf(prop.getProperty("selenide.selectorMode"));
    Configuration.assertionMode = AssertionMode.valueOf(prop.getProperty("selenide.assertionMode"));
    Configuration.fileDownload = FileDownloadMode.valueOf(prop.getProperty("selenide.fileDownload"));
    Configuration.proxyEnabled = Boolean.parseBoolean(prop.getProperty("selenide.proxyEnabled"));
    Configuration.proxyHost = prop.getProperty("selenide.proxyHost");
    Configuration.proxyPort = Integer.parseInt(prop.getProperty("selenide.proxyPort"));
    Configuration.driverManagerEnabled = Boolean.parseBoolean(prop.getProperty("selenide.driverManagerEnabled"));
    Configuration.headless = Boolean.parseBoolean(prop.getProperty("selenide.headless"));
  }
}
