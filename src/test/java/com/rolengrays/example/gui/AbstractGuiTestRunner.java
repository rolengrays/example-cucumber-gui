package com.rolengrays.example.gui;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.Properties;

public abstract class AbstractGuiTestRunner {
  protected final static Logger logger;
  private final static String SELENIDE_PROPERTIES;

  static {
    SELENIDE_PROPERTIES = "selenide.properties";
    logger = Logger.getLogger(AbstractGuiTestRunner.class.toString());
  }

  protected static void configureSelenide() {
    String propertiesPath = AbstractGuiTestRunner.class.getResource(SELENIDE_PROPERTIES).getPath();
    Properties prop = new Properties();
    try(FileReader fr = new FileReader(propertiesPath)) {
      prop.load(fr);
      prop.forEach((key, value) -> System.setProperty((String)key,(String)value));
      logger.info("selenide.propertiesの読み込みに成功しました。");
    } catch (IOException e) {
      e.printStackTrace();
      logger.warning("selenide.propertiesの読み込みに失敗しました。デフォルト値でテストを続行します。");
    }
  }
}
