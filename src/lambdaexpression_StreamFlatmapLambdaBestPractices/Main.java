package lambdaexpression_StreamFlatmapLambdaBestPractices;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args){

        List<String> someBingoNumbers = Arrays.asList(
                "N40","N36",
                "B12","B6",
                "G53", "G49", "g64"
        );

        List<String> gNumbers = new ArrayList<>();

        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s-> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);


        //EXAMPLE
        //Stream of stream objects
        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "071");
        //**We can create streams composed of any type of object, but we can't create a stream of mixed types**
        Stream<String> inNumberStream = Stream.of("N40", "N36","I26", "I17", "I29", "071");
        Stream<String> concatStream =  Stream.concat(ioNumberStream, inNumberStream);

        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(john);
        hr.addEmployee(jane);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(jack);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        //flatMap method wants a function returns the stream
        //flatMap is the one to use when we want to perform operations on the list but the list isn't the source.
        //Object containing the list as a source
        //We use the method to create s stream of all objects in those lists
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        //we want to save the result of out first example where the uppercase filtered and sortef bingo number instead of printing the list
        //To do this we use the collect method and store their contents of the stream at the end of chain into a silt
        System.out.println("---------------");
//        List<String> sortedGNumbers = someBingoNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s -> s.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toList());

        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
                //first argument is supplier which create a objects,  second argument - supplier constructs the new arraylist, 3 argument - passing method reference
                //adAll method is the combiner
        for(String s : sortedGNumbers){
            System.out.println(s);
        }

        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s ->{
                    System.out.println(s);
                    return s.length() == 3 ;
                })
        .count(); //to get the result we have to add terminal operation

    }
}
