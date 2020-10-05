import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class TestMyIterableImpl {

    private Map<Object, List<?>> testData;

    public TestMyIterableImpl() {
        testData = new HashMap<>();
        testData.put(Integer.class, Arrays.asList(1, 2, 3, 4, 5));
        testData.put(Float.class, Arrays.asList(1f, 1.5f, 2f, 2.5f, 3f, 3.5f, 4f, 4.2f, 4.5f));
        testData.put(String.class, Arrays.asList("abc", "abb", "acc", "dab", "dbc"));
        testData.put(Boolean.class, Arrays.asList(true, false, true));
    }

    @Test
    public void testFilterForInt() {
        Predicate<Integer> evenNumber = integer -> integer%2 == 0;
        List<Integer> expected = Arrays.asList(2, 4);
        List<Integer> actual = (List<Integer>)
                MyIterableImpl.filter((List<Integer>) testData.get(Integer.class), evenNumber);

        compareTwoLists(expected, actual);
    }

    @Test
    public void testFilterForFloat() {
        Predicate<Float> bigger = f -> f > 3.2 ;
        List<Float> expected = Arrays.asList(3.5f, 4f, 4.2f, 4.5f);
        List<Float> actual = (List<Float>)
                MyIterableImpl.filter((List<Float>) testData.get(Float.class), bigger);

        compareTwoLists(expected, actual);
    }

    @Test
    public void testFilterForString() {
        Predicate<String> startsWithA = str -> str.charAt(0) == 'a';
        List<String> expected = Arrays.asList("abc", "abb", "acc");
        List<String> actual = (List<String>)
                MyIterableImpl.filter((List<String>) testData.get(String.class), startsWithA);

        compareTwoLists(expected, actual);
    }

    @Test
    public void testFilterForBoolean() {
        Predicate<Boolean> trueValues = b -> b;
        List<Boolean> expected = Arrays.asList(true, true);
        List<Boolean> actual = (List<Boolean>)
                MyIterableImpl.filter((List<Boolean>) testData.get(Boolean.class), trueValues);

        compareTwoLists(expected, actual);
    }

    @Test
    public void testTransformForInt() {
        Function<Integer, Integer> multiplied = a -> a * 2;
        List<Integer> expected = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> actual = (List<Integer>)
                MyIterableImpl.transform((List<Integer>) testData.get(Integer.class), multiplied);

        compareTwoLists(expected, actual);
    }

    @Test
    public void testTransformForFloat() {
        Function<Float, Float> newFloats = a -> Math.round((a - 0.5f) * 10f) / 10f;
        List<Float> expected = Arrays.asList(0.5f, 1f, 1.5f, 2f, 2.5f, 3f, 3.5f, 3.7f, 4f);
        List<Float> actual = (List<Float>)
                MyIterableImpl.transform((List<Float>) testData.get(Float.class), newFloats);

        compareTwoLists(expected, actual);
    }

    @Test
    public void testTransformForString() {
        Function<String, String> newStrings = s -> s + "b";
        List<String> expected = Arrays.asList("abcb", "abbb", "accb", "dabb", "dbcb");
        List<String> actual = (List<String>)
                MyIterableImpl.transform((List<String>) testData.get(String.class), newStrings);

        compareTwoLists(expected, actual);
    }

    @Test
    public void testTransformForBoolean() {
        Function<Boolean, Boolean> inverse = b -> !b;
        List<Boolean> expected = Arrays.asList(false, true, false);
        List<Boolean> actual = (List<Boolean>)
                MyIterableImpl.transform((List<Boolean>) testData.get(Boolean.class), inverse);

        compareTwoLists(expected, actual);
    }

    private <T> void compareTwoLists(List<T> first, List<T> second) {
        assertTrue(first.size() == second.size() && first.containsAll(second) && second.containsAll(first));
    }
}
