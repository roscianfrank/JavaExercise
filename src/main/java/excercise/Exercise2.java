package excercise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Exercise2 {
    public static void main(String[] args) {
        duplicateWordWithStream("alex brian charles alex charles david eric david");
        isPrime(8);
        System.out.println(generatePrimes2(50));
        System.out.println(generatePrimes(50));
        System.out.println(duplicateWord("my hello world my world"));
    }

    public static String duplicateWord(String word){
        if(word.isEmpty()){
            return String.valueOf(new Exception(new Throwable("String is empty")));
        }

        List<String> wordList;
        wordList = List.of(word.split(" "));

        Set<String> uniqueWords = new HashSet<String>();
        String duplicateWord = null;
        for (String i: wordList) {
            if(!uniqueWords.add(i)){
                duplicateWord = i;
                break;
            }
        }


        if(duplicateWord == null){
            return String.valueOf(new Exception(new Throwable("No duplicate word found")));
        }
        return duplicateWord;
    }

    public static void duplicateWordWithStream(String sentence){
        List<String> wordList = Arrays.stream(sentence.split(" ")).toList();
        Set<String> tempSet = new HashSet<>();
        List<String> duplicateWords = wordList.stream()
                .filter(w -> !tempSet.add(w))
                .toList();
        System.out.println("Duplicate words: " + duplicateWords);
        Map<String, Integer> wordMapWithCount = wordList.stream()
                .collect(Collectors.toMap(Function.identity(), word -> 1, Math::addExact));

        System.out.println("word map with count: " +wordMapWithCount);

        Map<String, Integer> wordMapWithCount2 = wordMapWithCount.entrySet()
                .stream().filter(e -> e.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(wordMapWithCount2);
    }
    public static boolean isPrime(int number) {
        boolean isPrime = false;
        if (number < 2) {
            System.out.println(" The number "+ number +" is prime: " + isPrime);
            return isPrime;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                System.out.println(" The number "+ number +" is prime: " + isPrime);
                return isPrime;
            }
        }
        isPrime = true;
        System.out.println(" The number "+ number +" is prime: " + isPrime);
        return isPrime;
    }
    public static List<Integer> generatePrimes(int n) {
        boolean[] isComposite = new boolean[n+1];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!isComposite[i]) {
                primes.add(i);
                for (int j = i*i; j <= n; j += i) {
                    isComposite[j] = true;
                }
            }
        }
        return primes;
    }
    public static List<Integer> generatePrimes2(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes;
    }
}
