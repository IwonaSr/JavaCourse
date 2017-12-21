package lambdaexpression_challengePart2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //How can we tell whether we can map a lambda expression to it?
        // The interface has to be functional interface. It can have only a single method that must be implemented.
        //A fnctional interface can contain more than one moethod, but all the methods but one must have default implementations
        // example is Comparator itrrface with one method which has to be implemented "compare()"


        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "harry"
        );


//        topNames2015.stream().map(String::toUpperCase).sorted().forEach(System.out::println);
        topNames2015.forEach(name -> {
//            if(name.matches("^[a-z]*$")){
                String firstLetter = String.valueOf(name.charAt(0));
                        String newName = firstLetter.toUpperCase() + name.substring(1,name.length());
                System.out.println("new name " + newName + "\n");
//            }
        });

        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(name ->
        firstUpperCaseList.add(name.substring(0,1).toUpperCase() +  name.substring(1)));
        firstUpperCaseList.sort((s1, s2)-> s1.compareTo(s2));
        firstUpperCaseList.forEach(s -> System.out.println(s));


        //CHALLENGE 10 - using Clas::MethodName
        List<String> firstUpperCaseList2 = new ArrayList<>();
        topNames2015.forEach(name ->
                firstUpperCaseList2.add(name.substring(0,1).toUpperCase() +  name.substring(1)));
        firstUpperCaseList2.sort(String::compareTo);
        firstUpperCaseList2.forEach(System.out::println
        );


        topNames2015.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        //CHALLENGE 12


//        long  name2 = topNames2015.stream()
//                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
//                .filter(name -> name.startsWith("A"))
//                .count();
//        System.out.println(name2);

//        long nameBeginningWithA = topNames2015.stream().map()

        //meotd like map() and filter() are intermediate, calls to them return immediately, are lazy method
        //terminal operation findFirst, reduce, peek

        //CHALLENGE 14 - terminal operation - peek -  printing item

        System.out.println("start with A");
        long name3 = topNames2015.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .peek(System.out::println)
                .count();

        System.out.println("start with A");
        List<String> name4 = topNames2015.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .peek(System.out::println)
                .collect(Collectors.toList());


    }

    public interface Names{

        public String sortTheNamesFromTheList(ArrayList<String> array);
    }
}

