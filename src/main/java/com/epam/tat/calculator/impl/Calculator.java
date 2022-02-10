package com.epam.tat.calculator.impl;

import com.epam.tat.calculator.ICalculator;

import static java.lang.Double.*;

public class Calculator implements ICalculator {

    private int precision;

    public Calculator(int precision) {
        this.precision = precision;
    }

    @Override
    public double add(double a, double b) {
        double result = a + b;
        double scale = Math.pow(10.0, precision);
        if (a + b > MAX_VALUE) {
            return Double.parseDouble(("Infinity"));
        }
        else if (a + b < -MAX_VALUE) {
            return Double.parseDouble(("-Infinity"));
        }
        else return Math.round(result * scale) / scale;

    }

    @Override
    public double subtract(double a, double b) {
        double result = a - b;
        double scale = Math.pow(10.0, precision);
        if (a - b > MAX_VALUE) {
            return Double.parseDouble(("Infinity"));
        }
        else if (a - b < -MAX_VALUE) {
            return Double.parseDouble(("-Infinity"));
        }
        else return Math.round(result * scale) / scale;
    }

    @Override
    public double multiply(double a, double b) {
        double result = a * b;
        double scale = Math.pow(10.0, precision);
        if (a * b > MAX_VALUE) {
            return Double.parseDouble(("Infinity"));
        }
        else if (a * b < -MAX_VALUE) {
            return Double.parseDouble(("-Infinity"));
        }
        else return Math.round(result * scale) / scale;
    }

    @Override
    public double divide(double a, double b) {
        double result = a / b;
        if (b != 0) {
            double scale = Math.pow(10.0, precision);
            return Math.round(result * scale) / scale;
        }
        else if (a / b > MAX_VALUE) {
            return Double.parseDouble(("Infinity"));
        }
        else if (a / b < -MAX_VALUE) {
            return Double.parseDouble(("-Infinity"));
        }
        else
            return result;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator(2);

        System.out.println("The addition is: " + calculator.add(2.123,-3.433));
        System.out.println("The subtraction is: " + calculator.subtract(1.455, 2.3333));
        System.out.println("The multiplication is: " + calculator.multiply(-2.444, 2.45667));
        System.out.println("The division is: " + calculator.divide(0.3456, 1.123));

    }
}

