package lambdaexpression_Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){

        List<String> someBingoNumbers = Arrays.asList(
                "N40","N36",
                "B12","B6",
                "G53", "G49", "g64"
        );

        List<String> gNumbers = new ArrayList<>();
        //EXAMPLE  - get G kolumn numbers
//        someBingoNumbers.forEach(number ->{
//            if(number.startsWith("G")){
//                gNumbers.add(number);
//                System.out.println(number);
//            }
//        });
//
//        gNumbers.sort((String s1, String s2)-> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));

        //using stream
        //stream is a set of object references, the stream method which was added to the collection class in Java 8 creates a stream from a collection.
        //Each object reference in the stream corresponds to an object in the collection and the ordering object reference matches the ordering of the collection
        //In fact any stream operations that we use have to meet two requirements:
        //1. They must be non-interferering which means tath they don't change the stream source in any way
        //2. They must be stateless so the result of an operation can't depend on any state outside of the operation. Example of that would be that it can't depend on variable values in previous step
        //Each operation should be seen as on independent step that's operating on stream argment.
        //Map method - we are passing the string to uppercase method. Method referred to String using colon colon notation which is called a method reference.
        //Map method accepts a function. We are mapping a String to UpperCase method to function. String object is used to invoke the method. Returned value is a String returned from uppercase method
        // the same meaning as s -> s.toUpperCase()
        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s-> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        //Map returns stream  which contains all the uppercase bingo numbers.
        //The map method maps each source string to the Function result,  therefore the upper-cased string is added to the resulting stream and passed to the next step in the chain. The resulting stream has the same number of itmes as the source stream.
        //Each stream operation operates on the stream result from the last/previous step.
        //In the next steps we want to filter the stream. To do this we use the filter method. Filter method need the predicate which is lambda expression. The lambda expression returns true or false value.
        //Resulting stream contains only those items for which the predicate returns true.
        //Sorted method accepts comparator parameter, but we don't need to provide one in this case.
        //forEach method takes consumer argument. For each method doesn't return a value so basically there is nothing to pass on to onther step.
        //forEach method is called s terminal operaiton. Terminal operaiton returns either void or non stream result.




    }
}
