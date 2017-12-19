package lambdaexpression_Introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //EXAMPLE 1.

//        new Thread(new CodeToRun()).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("prinring from the Runnable");
            }
        }).start();


//        //Replacing above runnable example to one line lambda expression
        new Thread(()-> System.out.println("Printing from the runnable")).start();

//
//        //lambda expression got three parts:
//        //first one is the argument list
//        //secon one is arrow token
//        //thirdly the body
//
//        //thread classes constructors accepts a runnable parameter and in adition it also knows that runnable interface only has one method in this case run which doesn't take any parameters
//        //so it able to match the lambda expressions argument list no paranmeters with run method
//        //lambda expression can only be used with interfaces that contain only one method that has to be implemented - functional interfaces
//        //We can use lamba expression instead of creating a class that implements runnable or using an anonymous class, able to reduce the lines of codes

        //EXAMPLE 2
        //method with multiple line of code example
        new Thread(() -> {
            System.out.println("Printing from the Runnable");
            System.out.println("Line 2");
            System.out.format("This is line %d\n", 3);

        }).start();

        //EXAMPLE 3
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tom ", 21);
        Employee jack = new Employee("Jack hill", 40);
        Employee snow = new Employee("Snow white", 40);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        Collections.sort(employees, new Comparator<Employee>(){
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });

        //Relevant regular expression - second parameter is lambda expression,
        // instead of passing types in lambda: we dont need to include types in a lambda in our case, compiler can infer from the first parameter "employees"
        //that the objects to be compared were both be of type employee

        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));


        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

        //EXAMPLE 4

        String sillyString = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);

        //instead of an anonymous class we can use lambda expression:
        //we can save lambda expression as variable, and that same lambda in more than one place
//        UpperConcat uc = (String s1, String s2) -> s1.toUpperCase() + s2.toUpperCase();
//        UpperConcat uc = ( s1,  s2) -> s1.toUpperCase() + s2.toUpperCase();
//        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

        //EXAMPLE 5 -  if lambda with more than one statement then we have to use return keyword
        //we use curly braces when
//        UpperConcat uc = (s1, s2) ->{
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };

//        EXAMPLE 6 - Nested blocks - replacing anonymous class by lambda expression
        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);


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

//        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class's name is: " + getClass().getSimpleName()); // return nothing, because the anonymous class does not have a name
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String1", "String2");

        //using anonymous class
//        UpperConcat uc = new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("i (within anonymous class) = " + i);
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        };
//
//        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
//        return Main.doStringStuff(uc, "string1", "string2");

        //using lambda expression
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lamba expression's class is " + getClass().getSimpleName());
            //print the name of class "AnotherClass", the lambda expresssion isnt a class
            //Lambda is treated like a nest block of code and it has the same scope as a nested block,
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
        return Main.doStringStuff(uc,"String1", "String2");
    }
}