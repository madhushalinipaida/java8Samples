import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8FeaturesExercises {
    public static void main(String args[]) {
        List<Integer> nums = Arrays.asList(14, 2, 3, 54, 54, 6, 6, 8);
        System.out.println("***Display list of even numbers in the given list***");
        nums.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        System.out.println("***Display all numbers starting with 1 ***");
        nums.stream()
                .filter(n -> n / 10 == 1)
                .forEach(System.out::println);

        System.out.println("***Duplicate elements in a given integer list***");
        Set<Integer> dup = new HashSet<>();
        nums.stream()
                .filter(n -> !dup.add(n))
                .forEach(System.out::println);

        System.out.println("***Find first element of the list***");
        nums.stream()
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("***Find total number of elements in the list***");
        long i = nums.stream()
                .count();
        System.out.println(i);

        System.out.println("***Find max elem in the list***");
        Optional<Integer> k = nums.stream()
                .max((i1, j) -> i1.compareTo(j));
        System.out.println(k.get());

        System.out.println("***Find first non repeated Character ***");
        String input = "aabbbcde";
        input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> input.indexOf(c) == input.lastIndexOf(c))
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("***Find first repeated Character ***");
        String str = "aabbbcde";
        str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> str.indexOf(c) != str.lastIndexOf(c))
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("***Sort all values using streams***");
        List<Integer> lst = Arrays.asList(87, 34, 23, 67, 23);
        lst.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("***Sort all values in descending order using streams***");
        lst.stream()
                .sorted(Collections.reverseOrder())
                .forEach(System.out::println);

        System.out.println("***Return true if provided int array has unique elems otherwise false***");
        Set<Integer> uniqElem = new HashSet<>();
        boolean val = lst.stream()
                .filter(c -> !uniqElem.add(c))
                .findFirst()
                .isEmpty();
        System.out.println(val);

        System.out.println("***Concatenate 2 streams***");
        List<String> strList = Arrays.asList("Hello", "Good", "Morning");
        List<String> strList1 = Arrays.asList("How", "Are", "You", "?");
        Stream<String> s1 = strList.stream();
        Stream<String> s2 = strList1.stream();
        Stream.concat(s1, s2)
                .forEach(System.out::println);

        System.out.println("***Sort array and convert to stream***");
        int[] arr = { 3, 6, 1, 5, 4 };
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);

        System.out.println("*** Use Stream map to convert strings to uppercase");
        strList.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("*** Count each element from String Arraylist ***");
        List<String> strs = Arrays.asList("AA", "BB", "CC", "DD", "AA");
        Map<String, Long> val1 = strs.stream()
                .collect(Collectors.groupingBy(st -> st, Collectors.counting()));
        for (String s : val1.keySet()) {
            System.out.println(s + "=" + val1.get(s));
        }

        System.out.println("*** Count duplicate elements from String Arraylist ***");
        List<String> lstStr = Arrays.asList("AAA", "BB", "CC", "D", "AAA", "D");
        Set<String> strs1 = new HashSet<>();
        Map<String, Long> dupElem = lstStr.stream()
                .filter(s -> Collections.frequency(lstStr, s) > 1)
                .collect(Collectors.groupingBy(sr -> sr, Collectors.counting()));

        System.out.println(dupElem);

        System.out.println("*** Max element in array***");
        int[] arr1 = { 1, 4, 5, 6, 89 };
        System.out.println(Arrays.stream(arr1)
                .max().getAsInt());

        System.out.println("***Write count of each character in a string***");
        String var = "Hi I am enjoying coding";
        Map<String, Long> test = Arrays.stream(var.split(""))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(test);

    }
}