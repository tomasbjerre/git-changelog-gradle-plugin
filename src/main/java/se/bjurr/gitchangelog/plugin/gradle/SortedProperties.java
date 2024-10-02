package se.bjurr.gitchangelog.plugin.gradle;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

/** https://stackoverflow.com/a/55957344/2477084 */
public class SortedProperties extends Properties {
  private static final long serialVersionUID = -4089258915252189905L;

  @Override
  public void store(final OutputStream out, final String comments) throws IOException {
    final Properties sortedProps =
        new Properties() {
          private static final long serialVersionUID = 2425274685932201267L;

          @Override
          public Set<Map.Entry<Object, Object>> entrySet() {
            /*
             * Using comparator to avoid the following exception on jdk >=9:
             * java.lang.ClassCastException:
             * java.base/java.util.concurrent.ConcurrentHashMap$MapEntry cannot be cast to
             * java.base/java.lang.Comparable
             */
            final Set<Map.Entry<Object, Object>> sortedSet =
                new TreeSet<>(
                    new Comparator<Map.Entry<Object, Object>>() {
                      @Override
                      public int compare(
                          final Map.Entry<Object, Object> o1, final Map.Entry<Object, Object> o2) {
                        return o1.getKey().toString().compareTo(o2.getKey().toString());
                      }
                    });
            sortedSet.addAll(super.entrySet());
            return sortedSet;
          }

          @Override
          public Set<Object> keySet() {
            return new TreeSet<Object>(super.keySet());
          }

          @Override
          public synchronized Enumeration<Object> keys() {
            return Collections.enumeration(new TreeSet<Object>(super.keySet()));
          }
        };
    sortedProps.putAll(this);
    sortedProps.store(out, comments);
  }
}
