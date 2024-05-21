package excercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Person1 {
    private String firstName;
    private String lastName;
    private int id;

    public Person1(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public static Map<String, List<Person1>> getCommonLastName(List<Person1> people) {
        return people.stream().collect(Collectors.groupingBy(Person1::getLastName));
    }

    @Override
    public String toString() {
        return "Person1{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }

    public static void main(String[] args) {
        List<Person1> people = new ArrayList<>();
        people.add(new Person1("roscian", "frank", 1));
        people.add(new Person1("jagruti", "frank", 2));
        people.add(new Person1("Riley", "frank", 3));
        people.add(new Person1("joe", "doe", 4));
        people.add(new Person1("jack", "doe", 5));
        people.add(new Person1("russle", "crow", 6));

        Map<String, List<Person1>> commonLastname = Person1.getCommonLastName(people);
        commonLastname.forEach((lastName, person1) -> System.out.println(lastName + " : " + person1));
    }


}


