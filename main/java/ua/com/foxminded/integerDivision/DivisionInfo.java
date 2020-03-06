package ua.com.foxminded.integerdivision;

public class DivisionInfo {
    private int dividend;
    private int divider;

    public DivisionInfo(int dividend, int divider) {
        this.dividend = dividend;
        this.divider = divider;
    }

    public int getDividend() {
        return this.dividend;
    }

    public int getDivider() {
        return this.divider;
    }
}
