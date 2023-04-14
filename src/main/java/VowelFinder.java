import java.util.Scanner;

public class VowelFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int vowelCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (isVowel(c)) {
                vowelCount++;
                System.out.print(c + " ");
            }
        }

        System.out.println("\nTotal number of vowels: " + vowelCount);
    }

    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);

        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}