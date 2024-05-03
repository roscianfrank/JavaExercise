package excercise;

import java.util.*;

public class collection {
    public static void main(String[] args) {
        //map();
        arrays();
    }

    public static void map(){
        Map<String, String> capitalCities = new TreeMap<String, String>();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");

        capitalCities.values().stream().filter(e -> e.contains("o")).forEach(System.out::println);
    }

    public static void arrays(){
        Integer[] array = new Integer[]{5,4,3,2,4,3,30,30,2,6,7};
        Integer[] ints = {5,3,6,9,2,3,6};
        List<Integer> list = Arrays.stream(ints).toList();
        list.stream().sorted().distinct().forEach(System.out::print);
        System.out.println('\n');

        System.out.println(Collections.max(Arrays.asList(ints)));

        System.out.println("Length of array:  "+array.length);
        HashSet<Integer> duplicate = new HashSet<>();
        List<Integer> duplicates = Arrays.stream(array)
                .filter(n -> !duplicate.add(n)) //Set.add() returns false if the item was already in the set.
                .toList();
        duplicates.stream().sorted().forEach(System.out::println);
    }
}
