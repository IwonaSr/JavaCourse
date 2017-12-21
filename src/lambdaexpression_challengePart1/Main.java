package lambdaexpression_challengePart1;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's do it";
                String[] parts = myString.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }

            }
        };


        //CHALLENGE 1 - write an anonymous class as lambda expression

//        new Thread( ()-> {
//            String myString = "Let's do it";
//            String[] parts = myString.split(" ");
//            for(String part: parts){
//                System.out.println(part);
//            }
//
//        }).start();

        Runnable runnable1 = () -> {
            String myString = "Let's do it";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        runnable.run();

        //CHALLENGE 2
        //First param is argument, second param is result
        Function<String,String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }

            return returnVal.toString();
        };

        //to execute the above function with an argument "12312321
//        System.out.println( lambdaFunction.apply("12312321"));

        //CHALLENGE 3

        //CHALLENGE 4

        //CHALLENGE 5
        String result = everySecondCharacter(lambdaFunction, "123214");
        System.out.println(result);

        //CHALLENGE 6 - using supplier

        //Supplier project object, we don't have to return key word it's implied
//        Supplier<String> iLoveJava = () -> "I love java";
        //if when we use return statment we have to use brackets
        Supplier<String> iLoveJava = () -> {
            return "I love java";
        } ;

        //CHALLENGE 7 - get to retireve the value
        String iLoveJava2 =   iLoveJava.get();
        System.out.println(iLoveJava2);



    }


    public static String everySecondCharacter(Function<String,String> function, String source){

        return function.apply(source);

    }
    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }

        return returnVal.toString();
    }

}
