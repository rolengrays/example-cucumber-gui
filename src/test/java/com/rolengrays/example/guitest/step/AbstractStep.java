package com.rolengrays.example.guitest.step;

import com.rolengrays.example.guitest.ScenarioContext;

public abstract class AbstractStep {
  protected final ScenarioContext context;

  public AbstractStep(ScenarioContext context) {
    this.context = context;
  }
}
