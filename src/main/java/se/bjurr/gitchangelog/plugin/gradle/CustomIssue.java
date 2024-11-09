package se.bjurr.gitchangelog.plugin.gradle;

import java.util.Objects;

public class CustomIssue {
  private String name;

  private String pattern;

  private String link;

  private String title;

  public CustomIssue() {}

  public String getName() {
    return this.name;
  }

  public CustomIssue setName(final String name) {
    this.name = name;
    return this;
  }

  public String getPattern() {
    return this.pattern;
  }

  public CustomIssue setPattern(final String pattern) {
    this.pattern = pattern;
    return this;
  }

  public String getLink() {
    return this.link;
  }

  public CustomIssue setLink(final String link) {
    this.link = link;
    return this;
  }

  public String getTitle() {
    return this.title;
  }

  public CustomIssue setTitle(final String title) {
    this.title = title;
    return this;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.link, this.name, this.pattern, this.title);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    final CustomIssue other = (CustomIssue) obj;
    return Objects.equals(this.link, other.link)
        && Objects.equals(this.name, other.name)
        && Objects.equals(this.pattern, other.pattern)
        && Objects.equals(this.title, other.title);
  }

  @Override
  public String toString() {
    return "CustomIssue [name="
        + this.name
        + ", pattern="
        + this.pattern
        + ", link="
        + this.link
        + ", title="
        + this.title
        + "]";
  }
}
