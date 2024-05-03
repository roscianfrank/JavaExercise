package excercise;

import java.util.*;

public class RomanToInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Roman numeral: ");
        String romanNumeral = scanner.nextLine().toUpperCase();
        int result = romanToInteger(romanNumeral);
        System.out.println("Integer value: " + result);
    }

    public static int romanToInteger(String romanNumeral) {
        int result = 0;
        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            int current = romanValue(romanNumeral.charAt(i));
            if (result <= current || current == romanValue(romanNumeral.charAt(i))) {
                result += current;
            } else {
                result -= current;
            }
        }
        return result;
    }

    public static int romanValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
