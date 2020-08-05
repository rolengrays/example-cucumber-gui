package com.rolengrays.example.guitest.step;

import com.rolengrays.example.guitest.ScenarioContext;
import io.cucumber.java.ja.ならば;

import static org.assertj.core.api.Assertions.*;

public class BingGoogleResultMatch extends AbstractStep {

  public BingGoogleResultMatch(ScenarioContext context) {
    super(context);
  }

  @ならば("GoogleとBingの検索結果トップが一致する")
  public void matchGoogleBingResult() {
    String googleTop = context.googleResults.get(0);
    String bingTop = context.bingResults.get(0);
    assertThat(googleTop).isEqualTo(bingTop);
  }
}
