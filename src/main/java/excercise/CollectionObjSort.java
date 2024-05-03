package excercise;

import java.security.PublicKey;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionObjSort {
    public static void main(String[] args) {
        List<Student> studs = new ArrayList<>();
        studs.add(new Student(1, 44, "russull", "crow"));
        studs.add(new Student(2, 70, "jack", "sparrow"));
        studs.add(new Student(3, 38, "Ann", "patel"));
        studs.add(new Student(4, 90, "roscian", "frank"));
        studs.add(new Student(5, 70, "matt", "mohan"));

//        Collections.sort(studs, (s1, s2) -> {
//            return s1.marks > s2.marks ? -1 : 1;
//        });
        //using comparator.comparing which use getName method from student class
        //Same thing we can do it Integer for Comparator.comparingInt there is a reversed() method as well
        System.out.println("Sorted with ascending Name");
        studs.stream().sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);
        System.out.println("Sorted with highest marks");
        studs.stream().sorted(Comparator.comparingInt(Student::getMarks).reversed()).forEach(System.out::println);
    }

    static class Student {
        int rollNumber;
        int marks;
        String name;
        String lastname;

        public Student(int rollNumber, int marks, String name, String lastname) {
            this.rollNumber = rollNumber;
            this.marks = marks;
            this.name = name;
            this.lastname = lastname;
        }

        public String getName() {
            return name;
        }

        public int getMarks() {
            return marks;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "rollNumber=" + rollNumber +
                    ", marks=" + marks +
                    ", name='" + name + '\'' +
                    ", lastname='" + lastname + '\'' +
                    '}';
        }
    }


}
