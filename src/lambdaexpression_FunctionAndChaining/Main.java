package lambdaexpression_FunctionAndChaining;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

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


        //EXAMPLE - get last Name of each employee
        employees.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(' ' ));
            System.out.println(lastName);

        });

        //using lambda expression. Functional interface represent a function thath takes one parameter and return a value -  Functional method which uses the lambda expresion
        //EXAMPLE - functional interface - get Last name using apply function
        Function<Employee, String> getLastName = (Employee employee) ->{
            return employee.getName().substring(employee.getName().indexOf(' ' ));
        };

        String lastName = getLastName.apply(employees.get(2));
        System.out.println(lastName);


        //EXAMPLE - get first and last name
        Function<Employee, String> getFirstName = (Employee employee) ->{
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        Random random1 = new Random();
        for(Employee employee: employees){
            if(random1.nextBoolean()){
                System.out.println(getAName(getFirstName, employee));
            }else{
                System.out.println(getAName(getLastName, employee));
            }
        }

        //EXAMPLE - chaining function together - using andThen method. That methid takes a function as parameter
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        Function chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(employees.get(0)));



        }

    private static String getAName(Function<Employee, String> getName, Employee employee){
        return getName.apply(employee);
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