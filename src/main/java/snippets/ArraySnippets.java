package snippets;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
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

    /**
     * 拼接两个数组
     * @param first
     * @param second
     * @param <T>
     * @return
     */
    public static <T> T[] concat(T[] first, T[] second) {
        return Stream.concat(Stream.of(first), Stream.of(second))
                .toArray(i -> (T[]) Arrays.copyOf(new Object[0], i, first.getClass()));
    }

    /**
     * 计算数组中某个值出现的次数。
     * @param numbers
     * @param value
     * @return
     */
    public static long countOccurrences(int[] numbers,int value) {
        return Arrays.stream(numbers)
                .filter(i -> i == value)
                .count();
    }

    /**
     * 数组扁平化。数组扁平化是指将一个多维数组变为一维数组
     * @param input
     * @return
     */
    public static int[] deepFlatten(Object[] input) {
        return Arrays.stream(input)
                .flatMapToInt(o -> {
                    if (o instanceof Object[]) {
                        return Arrays.stream(deepFlatten((Object[]) o));
                    }
                    return IntStream.of((Integer) o);
                }).toArray();
    }

    /**
     * 返回两个数组之间的差异。
     * 从 b 中创建一个集合，然后在 a 上使用 Arrays.stream().filter() 只保留 b 中不包含的值。
     * @param first
     * @param second
     * @return
     */
    public static int[] difference(int[] first, int[] second) {
        Set<Integer> set = Arrays.stream(second).boxed().collect(Collectors.toSet());
        return Arrays.stream(first)
                .filter(item -> !set.contains(item))
                .toArray();
    }



    public static void main(String[] args) {
//        Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);
//        IntStream.generate(new IntSupplier() {
//            @Override
//            public int getAsInt() {
//                return new Random().nextInt();
//            }
//        }).limit(10).forEach(new IntConsumer() {
//            @Override
//            public void accept(int value) {
//                System.out.println(value);
//
//            }
//        });

//        OptionalInt optionalInt = IntStream.generate(() -> new Random().nextInt()).limit(10).max();
//        if (optionalInt.isPresent()) {
//            System.out.println(optionalInt.getAsInt());
//        }
//        Integer integer = 12;
//        OptionalInt optionalInt1 = OptionalInt.empty();
//        optionalInt1.ifPresent(System.out::println);



        List<String> strs = Arrays.asList("好,好,学", "习,天,天", "向,上");

        List<String[]> strArray = strs.stream().map(str -> str.split(",")).collect(Collectors.toList());

        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(strArray));

        System.out.println("strArray => " + jsonArray.toString());

        // flatMap与map的区别在于 flatMap是将一个流中的每个值都转成一个个流，然后再将这些流扁平化成为一个流 。
        List<String> strList = strs.stream().map(str -> str.split(",")).flatMap(Arrays::stream)
                .collect(Collectors.toList());

        System.out.println("strList => " + strList);

    }

}
