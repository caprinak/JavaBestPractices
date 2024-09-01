package Lambda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class GroupingbyVariantsDemo {
    public static void main(String[] args) {
        setFreq();
         freq.entrySet().stream().filter(x -> x.getValue() > 1).forEach(System.out::println);
       // System.out.println(getN(10));
    }

    // Proper use of streams to initialize a frequency table
    static Map<String, Long> freq;

    public static void setFreq() {
        try (Stream<String> words = new Scanner(new File("test.txt")).tokens()) {
            freq = words
                    .collect(groupingBy(String::toLowerCase, counting()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    // Pipeline to get a top-ten list of words from a frequency table
  /* static List<String> topTen = freq.keySet().stream()
            .sorted(comparing(freq::get).reversed())
            .limit(10)
            .collect(toList());*/

    public static List<String>  getN(int n){
        List<String> topN = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(n)
                .collect(toList());
        return  topN;
    }
}
