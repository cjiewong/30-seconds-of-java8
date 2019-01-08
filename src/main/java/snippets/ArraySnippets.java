package snippets;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author cjie
 * @Date 2019/1/8 0008.
 */
public class ArraySnippets {
    /**
     * 将数组分割成特定大小的小数组。
     * @param numbers
     * @param size
     * @return
     */
    public static int[][] chunk(int[] numbers, int size) {
        return IntStream.iterate(0, i -> i + size)
                .limit((long) Math.ceil((double) numbers.length / size))
                .mapToObj(cur -> Arrays.copyOfRange(numbers, cur, cur + size > numbers.length ? numbers.length : cur + size))
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
        Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);
    }

}
