import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testRun() {
        Solution s = new Solution();
        assertEquals(8, s.run(new int[] {5,3,2,2,3,5,4,6,9,6,4,12,8,9,12}));
    }
}
