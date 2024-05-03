package excercise;

import java.util.*;

public class Coll {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(434,1,3,67,3,245);
        num.stream().distinct().sorted().forEach(System.out::println);

        Set<String> words = new HashSet<>();
        words.add("a");
        words.add("b");
        words.add("c");
        words.add("d");
        System.out.println(words.add("b"));
        //words.stream().forEach(System.out::println);

        Map<String, String> uni = new HashMap<>();

        uni.put("name", "Rajesh");
        uni.put("forName", "Kutrrapalli");

        System.out.println(uni.get("name"));
        System.out.println(uni.get("forName"));
        System.out.println(uni.size());
        for(String i: uni.keySet()){
            System.out.println("Keys "+i);
        }
        for(String i: uni.values()){
            System.out.println("values " + i);
        }



    }
}
