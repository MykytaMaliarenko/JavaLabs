import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyIterableImpl {

    //Returns a view of unfiltered containing all elements that satisfy the input predicate retainIfTrue.
    public static <T> Iterable<T> filter(Iterable<T> unfiltered, Predicate<? super T> retainIfTrue) {
        List<T> result = new LinkedList<>();
        for (T temp: unfiltered) {
            if (retainIfTrue.test(temp))
                result.add(temp);
        }

        return result;
    }

    //Returns a view containing the result of applying function to each element of fromIterable.
    public static <F, T> Iterable<T> transform(Iterable<F> fromIterable,
                                               Function<? super F, ? extends T> function)
    {
        List<T> result = new LinkedList<>();
        for (F temp: fromIterable)
            result.add(function.apply(temp));

        return result;
    }
}
