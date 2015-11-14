package se.bjurr.byggarmonster.model.animal;

import se.bjurr.byggarmonster.model.person.Person;

public class Animal {
 private final String name;
 private final Person owner;

 public Animal(final String name, final Person owner) {
  this.name = name;
  this.owner = owner;
 }

 public String getName() {
  return name;
 }

 public Person getOwner() {
  return owner;
 }
}
