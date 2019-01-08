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
}
