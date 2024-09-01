package Lambda;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Prints all large anagram groups in a dictionary iteratively
public class Anagrams {
    public static void main(String[] args) throws IOException {
     //anagrams();
      usingLambda();
        System.out.println(testString());
    }

    static void anagrams() throws IOException {
        File dictionary = new File("D:\\Projects\\Assets\\Anagrams.txt");
        int minGroupSize = 1;
        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word),
                        (unused) -> new TreeSet<>()).add(word);
            }}
        for (Set<String> group : groups.values())
            if (group.size() >= minGroupSize)
                System.out.println(group.size() + ": " + group);
    }
    static void usingLambda() throws IOException {
        Path dictionary = Paths.get("D:\\Projects\\Assets\\Anagrams.txt");
        int minGroupSize = 1;
        try (Stream<String> words = Files.lines(dictionary))
        {
            words.peek(word -> System.out.println("Original word: " + word)).
                    map(String::trim)
                    /*.peek(word -> System.out.println("Trimmed word: " + word))
                    .map(String::toLowerCase)
                    .peek(word -> System.out.println("Lowercased word: " + word))*/
                    .collect(Collectors.groupingBy(Anagrams::alphabetize))
                   /* .keySet().stream().forEach(k -> System.out.println(k));*/
                    .values().stream()
                    .peek(group -> System.out.println("Group: " + group))
                    .filter(group -> group.size() >= minGroupSize)
                    .forEach(g -> System.out.println(g.size() + ": " + g));
        }
    }
    public  static boolean testString(){
        boolean result =  new String("Abc") == new String("Abc");
                return result;
    }
    public static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return String.valueOf(a);
    }}

