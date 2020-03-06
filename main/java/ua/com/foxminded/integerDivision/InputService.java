package ua.com.foxminded.integerdivision;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputService {

    public static int inputDividend() {
        int inputNumber = 1;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Type dividend integer: ");
            inputNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Your data isn't valid. It should be a number.");
            System.exit(1);
        }
        return inputNumber;
    }

    public static int inputDivider() {
        int inputNumber = 1;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Type divider integer: ");
            inputNumber = scanner.nextInt();
            if (inputNumber == 0) {
                throw new ArithmeticException("Division by zero is forbidden!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Your data isn't valid. It should be a number.");
            System.exit(1);
        }
        return inputNumber;
    }
}
