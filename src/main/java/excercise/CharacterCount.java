package excercise;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CharacterCount {
    public static void main(String[] args) {
        String input = "11122234445555";
        countOccurrence(input);
    }

    public static void countOccurrence(String input) {
        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sorted =
                countMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            System.out.println("Character '" + entry.getKey() + "' occurs " + entry.getValue() + " time(s)");
        }

        System.out.println("least occurrence " + sorted.entrySet().stream().findFirst());
        System.out.println("Max occurrence " + sorted.entrySet().stream().skip(sorted.size() - 1).findFirst().get());

    }
}
