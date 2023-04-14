import java.util.Arrays;

public class Pangram {
    public static void main(String[] args) {
        reverseSentence1("I am good");
        System.out.println("Reversed sentence: " + reverseASentence("I am good"));
        reverseString("abcdefg");
        reverseStringWithLoop("abcdefg");
        System.out.println(reverse(675432));
        System.out.println(checkPangram("The quick brown fox jumps over the lazy dog"));
        fibonacci(9);
        reverse(123);
        System.out.println("Reverse string is: " + reverse("hello world"));
        System.out.println("string is anagram : " + isAnagram("army", "mary"));
    }

    public static boolean checkPangram(String str) {
        boolean[] mark = new boolean[26];

        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            // If uppercase character, subtract 'A' to find index.
            char value = str.charAt(i);
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
                index = str.charAt(i) - 'A';
            else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z')
                index = str.charAt(i) - 'a';
            mark[index] = true;
        }
        for (int i = 0; i <= 25; i++)
            if (!mark[i])
                return (false);
        return (true);
    }

    public static void fibonacci(int count) {
        int prevNumber = 0;
        int nextNumber = 1;

        System.out.println("Fibonacci Series " + count + ":");
        for (int i = 1; i <= count; ++i) {
            int fib = prevNumber + nextNumber;
            prevNumber = nextNumber;
            nextNumber = fib;
            System.out.print(prevNumber + " ");
        }
    }


    public static long reverse(long num) {
        long sum = 0;
        while (num != 0) {
            long lastDigit = (num % 10);
            sum = (sum * 10) + lastDigit;
            num = num / 10;
        }
        System.out.println("\n" + "reverse of the number " + num + " = " + sum);
        return sum;
    }

    public static String reverse(String input) {
        if (input.isEmpty()) {
            System.out.println("String is empty now");
            return input;
        }
        return  reverse(input.substring(1)) + input.charAt(0);
    }

    public static String reverse(int value) {
        String input = String.valueOf(value);
        if (input.isEmpty()) {
            System.out.println("Integer is empty now");
            return input;
        }
        return  reverse(input.substring(1)) + input.charAt(0);
    }

    public static boolean isAnagram(String input1, String input2) {
        char[] sortedWord1 = input1.toCharArray();
        Arrays.sort(sortedWord1);

        char[] sortedWord2 = input2.toCharArray();
        Arrays.sort(sortedWord2);

        return Arrays.equals(sortedWord1, sortedWord2);
    }
    public static void reverseString(String inputString) {
        StringBuilder stringBuilder = new StringBuilder(inputString);
        stringBuilder = stringBuilder.reverse();
        System.out.println("reversed string with string buffer: "+stringBuilder.toString());
    }

    public static void reverseStringWithLoop(String input){
        char[] inputArray = input.toCharArray();
        String reversedString = "";
        for(int i = input.length()-1; i>=1 ;i--){
            reversedString +=inputArray[i];
        }
        System.out.println("reversed string with loop: "+ reversedString);
    }

    public static String reverseASentence(String s) {
        // Finding the index of the whitespaces
        int x = s.indexOf(" ");

        //Base condition
        if(x == -1)
            return s;

        //Recursive call
        return reverseASentence(s.substring(x+1)) +" "+ s.substring(0, x);
    }

    public static void reverseSentence1(String str){
        String rev= "";
        //Breaking the sentence into words
        String[] words = str.split(" ");

        //Adding the words stored in the array to the last
        for (String value : words) {
            rev = value + " " + rev;
        }

        //Printing the reversed sentence
        System.out.println("Reversed sentence: " + rev);
    }
}
