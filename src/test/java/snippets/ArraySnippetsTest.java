package snippets;

import org.junit.Assert;
import org.junit.Test;
/**
 * @Author cjie
 * @Date 2019/1/8 0008.
 */
public class ArraySnippetsTest {
    @Test
    public void chunk() {
        int[][] ints = ArraySnippets.chunk(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}, 3);
        Assert.assertEquals(ints.length,6);
    }

    @Test
    public void concat() {
        Integer[] concat = ArraySnippets.concat(new Integer[]{1, 2, 3}, new Integer[]{4, 5, 6});
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, concat);
    }

    @Test
    public void countOccurrences() {
        long occurrences = ArraySnippets.countOccurrences(new int[]{1, 2, 3, 3, 3, 1, 2, 3, 1}, 3);
        Assert.assertEquals(4, occurrences);
    }

    @Test
    public void deepFlatten() {
        int[] ints = ArraySnippets.deepFlatten(new Object[]{1, 2, 3, new Object[]{3, 7}});
        Assert.assertArrayEquals(new int[]{1, 2, 3, 3, 7}, ints);
    }

}
