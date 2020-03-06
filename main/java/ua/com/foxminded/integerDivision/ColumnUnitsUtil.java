package ua.com.foxminded.integerdivision;

import java.util.Collections;
import java.util.List;

public class ColumnUnitsUtil {

    public static String obtainFirstMinDividend(DivisionInfo divisionInfo) {
        int i = 1;
        StringBuilder minDividend = new StringBuilder();
        if (Math.abs(divisionInfo.getDividend()) < Math.abs(divisionInfo.getDivider())) {
            List<String> list = Collections.nCopies(Integer.toString(Math.abs(divisionInfo.getDividend())).length(), "0");
            for (String s : list) {
                minDividend.append(s);
            }
        } else {
            String dividendModule = Integer.toString(Math.abs(divisionInfo.getDividend()));
            while (Integer.parseInt(dividendModule.substring(0, i)) < Math.abs(divisionInfo.getDivider())) {
                i++;
            }
            minDividend = new StringBuilder(Integer.toString(Math.abs(divisionInfo.getDividend())).substring(0, i));
        }
        return minDividend.toString();
    }

    public static String obtainMinDividend(int minDividendRest, int index, DivisionInfo divisionInfo) {
        StringBuilder newMinimalDividend = new StringBuilder();
        newMinimalDividend.append(minDividendRest);
        if (minDividendRest < Math.abs(divisionInfo.getDivider())) {
            for (int newIndex = index; minDividendRest < Math.abs(divisionInfo.getDivider()); newIndex++) {
                newMinimalDividend.append(Integer.toString(Math.abs(divisionInfo.getDividend())).charAt(newIndex));
                minDividendRest = Integer.parseInt(newMinimalDividend.toString());
                if (newIndex + 1 == Integer.toString(Math.abs(divisionInfo.getDividend())).length()) {
                    break;
                }
            }
        }
        return newMinimalDividend.toString();
    }

    public static String calculateDivisionResult(DivisionInfo divisionInfo) {
        return Integer.toString(divisionInfo.getDividend() / divisionInfo.getDivider());
    }

    public static int calculateMaxMultiple(int minDividend, int divider) {
        return (minDividend / divider) * divider;
    }

    public static String substituteZerosForSpaces(String minDividend) {
        int minDividendLength = minDividend.length();
        int newMinDividend = Integer.parseInt(minDividend);
        int spacesLength = minDividendLength - Integer.toString(newMinDividend).length();
        return String.join("", Collections.nCopies(spacesLength, " "));
    }
}
