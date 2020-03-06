package ua.com.foxminded.integerdivision;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DivisionCalculatorTest {

    @Test
    void buildDivisionColumnShouldReturnArithmeticExceptionWhenItZeroDivider() throws ArithmeticException {
        assertThrows(ArithmeticException.class, () -> {
            DivisionCalculator divisionCalculator = new DivisionCalculator();
            divisionCalculator.buildIntegerDivider(346, 0);
        });
    }

    @Test
    void buildDivisionColumnShouldReturnGivenColumnWhenItGetsZeroDividend() {
        DivisionCalculator divisionCalculator = new DivisionCalculator();
        String actual = divisionCalculator.buildIntegerDivider(0, 65);
        StringBuilder expected = new StringBuilder();
        expected.append("_0|65" + "\n");
        expected.append(" 0|-" + "\n");
        expected.append(" -|0" + "\n");
        expected.append(" 0");
        assertEquals(expected.toString(), actual);
    }

    @Test
    void buildDivisionColumnShouldReturnGivenColumnWhenItGetsPositiveNumbers() {
        DivisionCalculator divisionCalculator = new DivisionCalculator();
        String actual = divisionCalculator.buildIntegerDivider(60002575, 5);
        StringBuilder expected = new StringBuilder();
        expected.append("_60002575|5" + "\n");
        expected.append(" 5       |--------" + "\n");
        expected.append(" -       |12000515" + "\n");
        expected.append("_10" + "\n");
        expected.append(" 10" + "\n");
        expected.append(" --" + "\n");
        expected.append("    _25" + "\n");
        expected.append("     25" + "\n");
        expected.append("     --" + "\n");
        expected.append("      _7" + "\n");
        expected.append("       5" + "\n");
        expected.append("       -" + "\n");
        expected.append("      _25" + "\n");
        expected.append("       25" + "\n");
        expected.append("       --" + "\n");
        expected.append("        0");
        assertEquals(expected.toString(), actual);
    }

    @Test
    void buildDivisionColumnShouldReturnGivenColumnColumnWhenItGetsNegativeNumbers() {
        DivisionCalculator divisionCalculator = new DivisionCalculator();
        String actual = divisionCalculator.buildIntegerDivider(-60002575, -5);
        StringBuilder expected = new StringBuilder();
        expected.append("_-60002575|-5" + "\n");
        expected.append("  5       |--------" + "\n");
        expected.append("  -       |12000515" + "\n");
        expected.append(" _10" + "\n");
        expected.append("  10" + "\n");
        expected.append("  --" + "\n");
        expected.append("     _25" + "\n");
        expected.append("      25" + "\n");
        expected.append("      --" + "\n");
        expected.append("       _7" + "\n");
        expected.append("        5" + "\n");
        expected.append("        -" + "\n");
        expected.append("       _25" + "\n");
        expected.append("        25" + "\n");
        expected.append("        --" + "\n");
        expected.append("         0");
        assertEquals(expected.toString(), actual);
    }

    @Test
    void buildDivisionColumnShouldReturnGivenColumnWhenItGetsNegativeDividend() {
        DivisionCalculator divisionCalculator = new DivisionCalculator();
        String actual = divisionCalculator.buildIntegerDivider(-60002575, 5);
        StringBuilder expected = new StringBuilder();
        expected.append("_-60002575|5" + "\n");
        expected.append("  5       |---------" + "\n");
        expected.append("  -       |-12000515" + "\n");
        expected.append(" _10" + "\n");
        expected.append("  10" + "\n");
        expected.append("  --" + "\n");
        expected.append("     _25" + "\n");
        expected.append("      25" + "\n");
        expected.append("      --" + "\n");
        expected.append("       _7" + "\n");
        expected.append("        5" + "\n");
        expected.append("        -" + "\n");
        expected.append("       _25" + "\n");
        expected.append("        25" + "\n");
        expected.append("        --" + "\n");
        expected.append("         0");
        assertEquals(expected.toString(), actual);
    }

    @Test
    void buildDivisionColumnShouldReturnGivenColumnWhenItGetsNegativeDivider() {
        DivisionCalculator divisionCalculator = new DivisionCalculator();
        String actual = divisionCalculator.buildIntegerDivider(60002575, -5);
        StringBuilder expected = new StringBuilder();
        expected.append("_60002575|-5" + "\n");
        expected.append(" 5       |---------" + "\n");
        expected.append(" -       |-12000515" + "\n");
        expected.append("_10" + "\n");
        expected.append(" 10" + "\n");
        expected.append(" --" + "\n");
        expected.append("    _25" + "\n");
        expected.append("     25" + "\n");
        expected.append("     --" + "\n");
        expected.append("      _7" + "\n");
        expected.append("       5" + "\n");
        expected.append("       -" + "\n");
        expected.append("      _25" + "\n");
        expected.append("       25" + "\n");
        expected.append("       --" + "\n");
        expected.append("        0");
        assertEquals(expected.toString(), actual);
    }

    @Test
    void buildDivisionColumnShouldReturnGivenColumnWhenItGetsEqualInputNumbers() {
        DivisionCalculator divisionCalculator = new DivisionCalculator();
        String actual = divisionCalculator.buildIntegerDivider(826323, 826323);
        StringBuilder expected = new StringBuilder();
        expected.append("_826323|826323" + "\n");
        expected.append(" 826323|-" + "\n");
        expected.append(" ------|1" + "\n");
        expected.append("      0");
        assertEquals(expected.toString(), actual);
    }

    @Test
    void buildDivisionColumnShouldReturnGivenColumnWhenItGetsBiggerDivider() {
        DivisionCalculator divisionCalculator = new DivisionCalculator();
        String actual = divisionCalculator.buildIntegerDivider(3, 32);
        StringBuilder expected = new StringBuilder();
        expected.append("_3|32" + "\n");
        expected.append(" 0|-" + "\n");
        expected.append(" -|0" + "\n");
        expected.append(" 3");
        assertEquals(expected.toString(), actual);
    }

    @Test
    void buildDivisionColumnShouldReturnGivenColumnWhenItGetsDividendWithSixZeros() {
        DivisionCalculator divisionCalculator = new DivisionCalculator();
        String actual = divisionCalculator.buildIntegerDivider(6000000, 5);
        StringBuilder expected = new StringBuilder();
        expected.append("_6000000|5" + "\n");
        expected.append(" 5      |-------" + "\n");
        expected.append(" -      |1200000" + "\n");
        expected.append("_10" + "\n");
        expected.append(" 10" + "\n");
        expected.append(" --" + "\n");
        expected.append("      _0" + "\n");
        expected.append("       0" + "\n");
        expected.append("       -" + "\n");
        expected.append("       0");
        assertEquals(expected.toString(), actual);
    }
}
