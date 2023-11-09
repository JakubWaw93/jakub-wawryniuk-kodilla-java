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

        int addExpectedResult = 15;
        if(addExpectedResult == calc.add(a, b)) {
            System.out.println("Test OK");
        }else{
            System.out.println("Error!");
        }

        int subtractExpectedResult = 9;
        if(subtractExpectedResult == calc.subtract(a, b)) {
            System.out.println("Test OK");
        }else{
            System.out.println("Error!");
        }


    }
}
