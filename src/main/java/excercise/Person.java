package excercise;

import java.util.*;
import java.util.stream.Collectors;

public class Person {
    private String firstName;
    private String lastName;
    private int id;

    public Person(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }

//    public static Map<String, List<Person>> getCommonLastNames(List<Person> people) {
//        Map<String, List<Person>> lastNameMap = new HashMap<>();
//
//        for (Person person : people) {
//            String lastName = person.getLastName();
//            lastNameMap.putIfAbsent(lastName, new ArrayList<>());
//            lastNameMap.get(lastName).add(person);
//        }
//
//        return lastNameMap;

//    }
        public static Map<String, List<Person>> getCommonLastNames(List<Person> people) {
            return people.stream()
                    .collect(Collectors.groupingBy(Person::getLastName));
        }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", "Doe", 1));
        people.add(new Person("Jane", "Doe", 2));
        people.add(new Person("Alice", "Smith", 3));
        people.add(new Person("Bob", "Johnson", 4));
        people.add(new Person("Charlie", "Smith", 5));

//        Map<String, List<Person>> commonLastNames = getCommonLastNames(people);
//        for (Map.Entry<String, List<Person>> entry : commonLastNames.entrySet()) {
//            System.out.println("Last Name: " + entry.getKey());
//            System.out.println("People: " + entry.getValue());
//            System.out.println();
//        }
        Map<String, List<Person>> commonLastNames = Person.getCommonLastNames(people);
        commonLastNames.forEach((lastName, persons) -> System.out.println(lastName + ": " + persons));
    }
}
