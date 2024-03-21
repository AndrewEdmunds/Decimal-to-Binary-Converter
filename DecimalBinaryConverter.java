//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

public class DecimalBinaryConverter {

    // Function to convert a decimal number (or interger part of a decimal number) to binary
    public static String decimalToBinary(int decimal) {
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            binary.insert(0, decimal % 2);
            decimal /= 2;
        }
        return binary.toString();
    }

    // Function to convert the decimal part of a decimal number to binary
    public static String decimalFractionToBinary(double fraction) {
        StringBuilder binary = new StringBuilder();
        while (fraction > 0) {
            if (binary.length() >= 32) {
                break; // Limit fraction to 32 bits
            }
            fraction *= 2;
            binary.append((int) fraction);
            fraction -= (int) fraction;
        }
        return binary.toString();
    }

    // Function to convert "whole" part of a binary number to the interger part of a decimal number
    public static int binaryIntegerToDecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            decimal += (binary.charAt(i) - '0') * Math.pow(2, binary.length() - 1 - i);
        }
        return decimal;
    }

    // Function to convert the "decimal" part of a binary number to the decimal part of a decimal number
    public static double binaryFractionToDecimal(String binary) {
        double decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            decimal += (binary.charAt(i) - '0') * Math.pow(2, -(i + 1));
        }
        return decimal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        // Prompt user for decimal numbers
        List<Double> decimalNumbers = new ArrayList<>(); 
        System.out.println("Enter decimal numbers (enter 'done' to finish input):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                double number = Double.parseDouble(input);
                decimalNumbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid decimal number or 'done' to finish input.");
            }
        }
        */

        // Convert each decimal number to binary and print the result
        double[] decimalNumbers = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 11.11};
        for (double number : decimalNumbers) {
            // Split the decimal number into integer and fractional parts
            int integerPart = (int) number;
            double fractionalPart = number - integerPart;

            // Convert both parts to binary
            String binaryIntegerPart = decimalToBinary(integerPart);
            String binaryFractionalPart = decimalFractionToBinary(fractionalPart);

            // Print the binary rep
            System.out.println("Decimal " + number + " is binary " + binaryIntegerPart + "." + binaryFractionalPart);
        }

        // Convert integer numbers to binary
        int[] wholeNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(" ");
        for (int number : wholeNumbers) {
            int integerPart = number;
            String binaryIntegerPart = decimalToBinary(integerPart);
            System.out.println("Number " + number + " is " +binaryIntegerPart+" in binary");
        }

        scanner.close();
    }
}

