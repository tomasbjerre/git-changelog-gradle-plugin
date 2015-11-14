package se.bjurr.byggarmonster;

import static se.bjurr.byggarmonster.model.person.PersonBuilder.person;

import java.util.ArrayList;
import java.util.List;

import se.bjurr.byggarmonster.model.animal.Animal;
import se.bjurr.byggarmonster.model.animal.AnimalBuilder;
import se.bjurr.byggarmonster.model.person.Person;
import se.bjurr.byggarmonster.model.person.PersonBuilder;

public class MainExample {
 public static void main(final String[] args) {

  final List<Person> friends = new ArrayList<Person>();
  friends.add(new Person("Jonatan", "J�nsson", new ArrayList<Person>()));
  friends.add(new Person("Petter", "Nordholm", new ArrayList<Person>()));

  final Person p1 = new Person("Tomas", "Bjerre", friends);
  final Person p2 = person() //
    .withFirstName("Tomas") //
    .withLastName("Bjerre") //
    .withFriends(friends) //
    .build();

  new Person("Tompa", p1.getLastName(), p1.getFriends());
  new PersonBuilder() //
    .from(p2) //
    .withFirstName("Tompa") //
    .build();

  final Animal a1 = new Animal("Zacke", new Person("Tomas", "Bjerre", new ArrayList<Person>()));
  final Animal a2 = new AnimalBuilder() //
    .withName("Zacke") //
    .withOwner( //
      new PersonBuilder() //
        .withFirstName("Tomas") //
        .withLastName("Bjerre") //
        .withFriends(new ArrayList<Person>()) //
        .build() //
    ) //
    .build();

  new Animal("Nisse", new Person(a1.getOwner().getFirstName(), a1.getOwner().getLastName(), new ArrayList<Person>()));
  new AnimalBuilder() //
    .from(a2) //
    .withName("Nisse") //
    .build();
 }
}
