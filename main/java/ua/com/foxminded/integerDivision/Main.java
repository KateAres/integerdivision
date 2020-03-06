package ua.com.foxminded.integerdivision;

public class Main {
    public static void main(String[] args) {
        DivisionCalculator divisionCalculator = new DivisionCalculator();
        divisionCalculator.buildIntegerDivider(InputService.inputDividend(), InputService.inputDivider());
    }
}
