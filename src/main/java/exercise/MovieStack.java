package exercise;

import java.util.*;

public class MovieStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of movies in the stack
        int m = sc.nextInt(); // number of movies to watch
        int[] stack = new int[n];
        for (int i = 0; i < n; i++) {
            stack[i] = i + 1; // initialize the stack with movies 1 to n
        }
        int[] movies = new int[m];
        for (int i = 0; i < m; i++) {
            movies[i] = sc.nextInt(); // get the movies to watch
        }
        String result = watchMovies(stack, movies);
        System.out.println(result);
    }

    public static String watchMovies(int[] stack, int[] movies) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> positions = new HashMap<>();
        for (int i = 0; i < stack.length; i++) {
            positions.put(stack[i], i); // map movie numbers to their positions in the stack
        }
        for (int movie : movies) {
            int position = positions.get(movie);
            sb.append(position).append(","); // record the number of movies above the current movie
            for (int j = position; j > 0; j--) {
                stack[j] = stack[j - 1]; // shift movies down in the stack
                positions.put(stack[j], j); // update their positions
            }
            stack[0] = movie; // put the current movie at the top of the stack
            positions.put(movie, 0); // update its position
        }
        sb.deleteCharAt(sb.length()-1); // remove the last comma
        return sb.toString();
    }
}
