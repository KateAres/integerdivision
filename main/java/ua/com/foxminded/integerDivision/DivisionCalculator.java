package ua.com.foxminded.integerdivision;

public class DivisionCalculator {

    public String buildIntegerDivider(int dividend, int divider) {
        DivisionCalculator divisionCalculator = new DivisionCalculator();
        DivisionInfo divisionInfo = new DivisionInfo(dividend, divider);
        System.out.println(divisionCalculator.buildDivisionColumn(divisionInfo));
        return divisionCalculator.buildDivisionColumn(divisionInfo);
    }

    private String buildDivisionColumn(DivisionInfo divisionInfo) {
        int dividend = divisionInfo.getDividend();
        int divider = divisionInfo.getDivider();
        int dividendModule = Math.abs(dividend);
        int dividerModule = Math.abs(divider);
        ColumnBuilder columnBuilder = new ColumnBuilder();
        if (dividendModule < dividerModule) {
            return columnBuilder.buildSmallerColumn(divisionInfo);
        } else {
            return columnBuilder.buildColumn(divisionInfo);
        }
    }
}
