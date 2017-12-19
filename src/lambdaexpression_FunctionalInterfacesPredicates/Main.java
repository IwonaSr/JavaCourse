package lambdaexpression_FunctionalInterfacesPredicates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        //Java.util.function package was added in Java 8.  That package contains functional interfaces that are meant to be use with lambda expressions.
        //That interfaces represent structure of lambda expressions
        //Example of using Predicates with lambda expression

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tom Hanks", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red RidingHood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        System.out.println("Employee over 30:");
        System.out.println("=====");
//        for( Employee employee: employees){
//            if(employee.getAge() > 30){
//                System.out.println(employee.getName());
//            }
//        }

//        employees.forEach(employee ->  {
//            if(employee.getAge() > 30){
//                System.out.println(employee.getName());
//            }
//        });

        //Predicate is a new functional interface defined in java.util.funciton package which can be used in all the context where an object needs to be evalueted for a given test condition.
        //Predicates arguments are just lambda expressions that match the predicate interface.
        //Predicate accept one argument and return a boolean value.
        //We can pass all sort of conditions to the method and we don't have to write a different if condition to filter the emplyees based on different age criteria.
        //All we need a  new lambda expression that can map to the predicate interface.
        printEmployeesByAge(employees, "Employee over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "\nEmployee 30 and under", employee -> employee.getAge() <= 30);


        //EXAMPLE - compare implementation of  with anonymouse class
        //We don't have to use lambda expression. We can always use anonymous class, also in this case we can pass an anonymous predicate to the method.
        printEmployeesByAge(employees, "\nEmployee 30 and under", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });


        //EXAMPLE -
        //There are other consumer and predicate interfacet that expects specific type of parameter e.g. the double consumer expects a lambda expression that has a double argument.
        //There is also an int consumer and a long consumer. In addition to predicate there is also double predicate: int predicate and long predicate.
        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;
        System.out.println(greaterThan15.test(10));
        int a = 20;
        System.out.println(greaterThan15.test(a + 5));

        //connection of 2 predicates. If 2 predicates return treu then the test method return true and false if one other predicate return false.
        System.out.println(greaterThan15.and(lessThan100).test(50));

        //EXAMPLE - Supplier interface - does not accept any arguments and it return a value. We call get method to retrieve its value. There are boolean supplier, double supplies, int supplier and long supplier
        Random random = new Random();
        for (int i=0 ; i < 10; i++){
            System.out.println(random.nextInt(1000));
        }

        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for (int i=0 ; i < 10; i++){
            System.out.println(randomSupplier.get());
        }


        //EXAMPLE - get last Name of each employee
        employees.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(' ' ));
            System.out.println("Last name is: " + lastName);

        });

        //using lambda expression. Functional interface represent a function thath takes one parameter and return a value -  Functional method which uses the lambda expresion
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition){
        System.out.println(ageText);
        System.out.println("==================");

        //loop passes each employee to the predicate test method which in turn uses the employee as a parameter or as the parameter for the lambda expression that maps to the predicate
        for(Employee employee: employees){
            if(ageCondition.test(employee)){
                System.out.println(employee.getName());
            }
        }

    }

}