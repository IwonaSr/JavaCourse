package lambdaexpression_ScopeAndFunctionalProgramming;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tom ", 21);
        Employee jack = new Employee("Jack hill", 40);
        Employee snow = new Employee("Snow white", 40);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);


        //EXAMPLE 1 - if the variable in the lambda expression has to be final?
        //lambda expression
        //employee variable is declared outside the lambda and it's values does change.
        //If it has to be effectively final to be used within the lambda?
        //Yes, it does. In this case employee variable is effectively final.
        //On each iteration of the loop a new employee variable is created and its results effectively final, so it's assigned once and then never changes.

        for(Employee employee : employees){
            System.out.println(employee.getName());
            new Thread(() -> System.out.println(employee.getAge())).start();
        }

        //To explain it we can use an old-style for loop and we get the same result.
        System.out.println("example of old-style for loop with lambda expression");
        for(int i = 0 ; i< employees.size(); i++){
            //For each iteration a new employee variable is created and its results is effectively final. So it's assigned once and then never changes.
            Employee employee = employees.get(i);
            System.out.println(employee.getName());
            new Thread(() -> System.out.println(employee.getAge())).start();
        }

        System.out.println("Try to use variable inside the lambda expression which is not final");
        //if we move the declaration of the employee variable  outside the for loop then it won't be effectively final at that point. We would not be able to use.
        //We will receive the error from Intelij that "variable used in lambda expression should be final or effectively final".
//        Employee employee;
//        System.out.println("example");
//        for(int i = 0 ; i< employees.size(); i++){
//            employee = employees.get(i);
//            System.out.println(employee.getName());
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }

        //EXAMPLE 2 - replacing for loop by lambda expression
        System.out.println("Replacing for loop by lambda expression");

        //Instead of below example of iterating over a list
//        for(Employee employee : employees){
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        }
        //we can use lambda expression to print names and ages
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });


        //Lambda are javas first step into functional programming which is a programming paradigm that focuses on computing and returning results.
        //We do not have to use a lambda expression and in place for lambda expression we can always use an anonymous class.
        //Some lambda expression can be difficult to read and understand especially when you didn't write the yourself.
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}
//class CodeToRun implements  Runnable{
//
//    @Override
//    public void run() {
//        System.out.println("Printing from the Runnable");
//
//    }
//}


class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {

        int i = 0;

        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lamba expression's class is " + getClass().getSimpleName());
            System.out.println("i in the lamba expression is  " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");
    }

    public void printValue() {
        int number = 25;

        Runnable r = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            System.out.println("The value is " + number);
        };

        new Thread(r).start();

    }
}