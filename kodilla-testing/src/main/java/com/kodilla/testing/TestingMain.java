package com.kodilla.testing;
import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args) {

        //test 1
        System.out.println("Test - pierwszy test jednostkowy.");

        Calculator calc = new Calculator();
        int a=12;
        int b=3;

        int addResult = 15;
        if(addResult == calc.add(a, b)) {
            System.out.println("Test OK");
        }else{
            System.out.println("Error!");
        }

        int subtractResult = 9;
        if(subtractResult == calc.subtract(a, b)) {
            System.out.println("Test OK");
        }else{
            System.out.println("Error!");
        }


    }
}
