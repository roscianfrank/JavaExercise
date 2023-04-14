import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieStackTest {
    @Test
    public void testRun() {
        MovieStack movieStack = new MovieStack();
        assertEquals("0,2,0", movieStack.watchMovies(new int[]{3, 1, 1}, new int[]{3, 1, 1}));
    }
}
