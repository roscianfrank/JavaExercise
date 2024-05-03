package excercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exercise {

    public static void main(String[] args) {
        System.out.println(findFirstRepeatedWords("My hello my hello fellow candidate. Hello again."));
    }

    public static String findFirstRepeatedWords(String paragraph) {

        //iterate the sentence until . (stop)
        String firstLine = paragraph.substring(0, paragraph.indexOf("."));
        firstLine = firstLine.toLowerCase();
        firstLine = firstLine.replaceAll("=", "");
        firstLine = firstLine.replaceAll(",", "");
        firstLine = firstLine.replaceAll(";", "");
        firstLine = firstLine.replaceAll("-", "");
        firstLine = firstLine.replaceAll(":", "");

        String[] words = firstLine.split(" ");

        //check if it exits in set
        Set<String> uniqueWords = new HashSet<>();
        String repeatedWord = null;

        String duplicateWord = Arrays.stream(words)
                .filter(e -> !uniqueWords.add(e))
                .findFirst().toString();

        System.out.println(duplicateWord);

        for (String word : words) {
            if (!uniqueWords.add(word)) {
                repeatedWord = word;
                break;
            }
        }

        //throw new exception
        if (repeatedWord == null) {
            throw new IllegalArgumentException();
        }

        return repeatedWord;
    }

}
