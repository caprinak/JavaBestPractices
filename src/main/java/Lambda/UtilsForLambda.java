package Lambda;

import java.util.*;
import java.util.stream.Collectors;


public class UtilsForLambda {
    public static void main(String[] args) {
        test();
    }
    public static  <T> List<T> getValidfromOptionalCollections(List<Optional<T>>  streamOfOptionals){
        /*return streamOfOptionals.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());*/
        return streamOfOptionals.stream().flatMap(Optional::stream)
                .collect(Collectors.toList());
    }
    // Returns maximum value in collection as an Optional<E>
    public static <E extends Comparable<E>>
    Optional<E> max(Collection<E> c) {
        if (c.isEmpty())
            return Optional.empty();
        E result = null;
        for (E e : c)if (result == null || e.compareTo(result) > 0)
            result = Objects.requireNonNull(e);
        return Optional.of(result);
    }

    public static void test() {
        List<Optional<String>> listOfOptionals = Arrays.asList(
                Optional.empty(), Optional.of("foo"), Optional.empty(), Optional.of("bar"));
        System.out.println(getValidfromOptionalCollections(listOfOptionals));

        List<Integer> listofInteger = Arrays.asList(3,11,8);
        System.out.println("max value in list "+ (max(listofInteger).isPresent()? max(listofInteger).get() : "no value"));
    }
}
