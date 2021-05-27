package se.bjurr.gitchangelog.plugin.gradle;

import com.github.jknack.handlebars.Helper;

public class HelperParam {
  private final String name;
  private final Helper<?> helper;

  public HelperParam(final String name, final Helper<?> helper) {
    this.name = name;
    this.helper = helper;
  }

  public Helper<?> getHelper() {
    return this.helper;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return "HelperParam [name=" + this.name + ", helper=" + this.helper + "]";
  }
}
