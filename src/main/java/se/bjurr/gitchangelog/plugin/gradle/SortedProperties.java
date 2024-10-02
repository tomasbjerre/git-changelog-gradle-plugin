package se.bjurr.gitchangelog.plugin.gradle;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

public class SortedProperties extends Properties {
  private static final long serialVersionUID = -4089258915252189905L;

  @Override
  public Enumeration<Object> keys() {
    final Enumeration<Object> keysEnum = super.keys();
    final Set<Object> keyList = new TreeSet<>();
    while (keysEnum.hasMoreElements()) {
      keyList.add(keysEnum.nextElement());
    }
    return Collections.enumeration(keyList);
  }
}
