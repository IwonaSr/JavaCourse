package lambdaexpression_StreamsIntermediateAndTerminalOperations;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        System.out.println("----------------------------");
//        System.out.println(concatStream.distinct().count());
        // to remove duplicate number we use distinct method

        //peak method to see the results from distinct() method
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println )
                .count());





    }
}
