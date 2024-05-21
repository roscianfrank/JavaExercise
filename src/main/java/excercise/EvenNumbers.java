package excercise;

import java.util.Arrays;
import java.util.List;

public class EvenNumbers {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(17, 23, 10, 20, 90, 19, 79, 78, 66);
        nums.stream().sorted().filter(n -> n % 2 == 0).forEach(System.out::println);

        // both array value will be updated to [4, 2, 3]
        int[] arr1 = {1,2,3};
        int[] aary2 = arr1;

        aary2[0] = 4;

        System.out.println("Arr1: "+ Arrays.toString(arr1));
        System.out.println("Arr2: "+ Arrays.toString(aary2));
    }


}
