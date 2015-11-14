package se.bjurr.byggarmonster.model.person;

import java.util.List;

public class Person {
 private final String firstName;
 private final List<Person> friends;
 private final String lastName;

 public Person(final String firstName, final String lastName, final List<Person> friends) {
  this.firstName = firstName;
  this.lastName = lastName;
  this.friends = friends;
 }

 public String getFirstName() {
  return firstName;
 }

 public List<Person> getFriends() {
  return friends;
 }

 public String getLastName() {
  return lastName;
 }
}
