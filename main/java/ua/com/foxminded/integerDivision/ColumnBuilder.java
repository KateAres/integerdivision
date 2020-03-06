package ua.com.foxminded.integerdivision;

import java.util.Collections;
import java.util.List;

public class ColumnBuilder {

    String buildColumn(DivisionInfo divisionInfo) {
        StringBuilder result = new StringBuilder();
        String minDividend = ColumnUnitsUtil.obtainFirstMinDividend(divisionInfo);
        int maxMultiple = ColumnUnitsUtil.calculateMaxMultiple(Integer.parseInt(minDividend), divisionInfo.getDivider());
        int index = minDividend.length();
        int dividendLength = Integer.toString(Math.abs(divisionInfo.getDividend())).length();
        if (index != dividendLength) {
            return buildSecondPart(buildFirstPart(result, divisionInfo), divisionInfo);
        } else {
            result.append(buildLastLine(Integer.parseInt(minDividend), maxMultiple, divisionInfo));
        }
        return result.toString();
    }

    private String buildFirstPart(StringBuilder result, DivisionInfo divisionInfo) {
        result.append(buildInitialLine(divisionInfo));
        String minDividend = ColumnUnitsUtil.obtainFirstMinDividend(divisionInfo);
        int maxMultiple = ColumnUnitsUtil.calculateMaxMultiple(Integer.parseInt(minDividend), divisionInfo.getDivider());
        int spaceLength = Integer.toString(Math.abs(divisionInfo.getDividend())).length() - minDividend.length();
        result.append(buildSecondLine(divisionInfo, maxMultiple, spaceLength))
                .append(buildThirdLine(divisionInfo, maxMultiple, spaceLength));
        return result.toString();
    }

    private String buildSecondLine(DivisionInfo divisionInfo, int maxMultiple, int spaceLength) {
        StringBuilder result = new StringBuilder();
        List<String> dashes = Collections.nCopies(ColumnUnitsUtil.calculateDivisionResult(divisionInfo).length(), "-");
        result.append(String.join("", Collections.nCopies(initialSpaces(divisionInfo), " ")))
                .append(maxMultiple).append(String.join("", Collections.nCopies(spaceLength, " ")))
                .append("|").append(String.join("", dashes)).append("\n");
        return result.toString();
    }

    private String buildThirdLine(DivisionInfo divisionInfo, int maxMultiple, int spaceLength) {
        StringBuilder result = new StringBuilder();
        List<String> dashes = Collections.nCopies(Integer.toString(maxMultiple).length(), "-");
        result.append(String.join("", Collections.nCopies(initialSpaces(divisionInfo), " ")))
                .append(String.join("", dashes))
                .append(String.join("", Collections.nCopies(spaceLength, " ")))
                .append("|").append(ColumnUnitsUtil.calculateDivisionResult(divisionInfo)).append("\n");
        return result.toString();
    }

    private String buildSecondPart(String firstPart, DivisionInfo divisionInfo) {
        StringBuilder result = new StringBuilder();
        result.append(firstPart);
        String minDividend = ColumnUnitsUtil.obtainFirstMinDividend(divisionInfo);
        int maxMultiple = ColumnUnitsUtil.calculateMaxMultiple(Integer.parseInt(minDividend), divisionInfo.getDivider());
        int index = minDividend.length();
        int minDividendRest;
        do {
            minDividendRest = Integer.parseInt(minDividend) - maxMultiple;
            minDividend = ColumnUnitsUtil.obtainMinDividend(minDividendRest, index, divisionInfo);
            maxMultiple = ColumnUnitsUtil.calculateMaxMultiple(Integer.parseInt(minDividend), divisionInfo.getDivider());
            index += (minDividend.length() - Integer.toString(minDividendRest).length());
            int spacesBeforeMaxMultipleLine = index + initialSpaces(divisionInfo) - Integer.toString(maxMultiple).length();
            int spacesBeforeMinDividendLine = index - minDividend.length() + initialSpaces(divisionInfo) - 1;
            result.append(String.join("", Collections.nCopies(spacesBeforeMinDividendLine, " ")))
                    .append(ColumnUnitsUtil.substituteZerosForSpaces(minDividend))
                    .append("_").append(Integer.parseInt(minDividend)).append("\n")
                    .append(appendMaxMultipleLines(spacesBeforeMaxMultipleLine, maxMultiple));
        } while (index < Integer.toString(Math.abs(divisionInfo.getDividend())).length());
        result.append(buildLastLine(Integer.parseInt(minDividend), maxMultiple, divisionInfo));
        return result.toString();
    }

    private String appendMaxMultipleLines(int spacesBeforeLine, int maxMultiple) {
        StringBuilder result = new StringBuilder();
        String dashes = String.join("", Collections.nCopies(Integer.toString(maxMultiple).length(), "-"));
        result.append(String.join("", Collections.nCopies(spacesBeforeLine, " ")))
                .append(maxMultiple).append("\n")
                .append(String.join("", Collections.nCopies(spacesBeforeLine, " ")))
                .append(dashes).append("\n");
        return result.toString();
    }

    private String buildLastLine(int minDividend, int maxMultiple, DivisionInfo divisionInfo) {
        StringBuilder result = new StringBuilder();
        int index = Integer.toString(Math.abs(divisionInfo.getDividend())).length();
        int resultOfSubtraction = minDividend - maxMultiple;
        int spacesBeforeLine = index + initialSpaces(divisionInfo) - Integer.toString(resultOfSubtraction).length();
        result.append(String.join("", Collections.nCopies(spacesBeforeLine, " ")))
                .append(resultOfSubtraction);
        return result.toString();
    }

    String buildSmallerColumn(DivisionInfo divisionInfo) {
        StringBuilder result = new StringBuilder();
        int dividend = divisionInfo.getDividend();
        result.append(buildInitialLine(divisionInfo));
        List<String> spaces = Collections.nCopies(Integer.toString(dividend).length(), " ");
        String spacesBeforeLine = String.join("", spaces);
        result.append(spacesBeforeLine).append("0|-").append("\n").append(spacesBeforeLine)
                .append("-|0").append("\n");
        int dividendLength = Integer.toString(dividend).length();
        int spaceLength = dividendLength + 1 - Integer.toString(Math.abs(dividend)).length();
        result.append(String.join("", Collections.nCopies(spaceLength, " ")))
                .append(Math.abs(divisionInfo.getDividend()));
        return result.toString();
    }

    private String buildInitialLine(DivisionInfo divisionInfo) {
        return "_" + divisionInfo.getDividend() + "|" + divisionInfo.getDivider() + "\n";
    }

    private int initialSpaces(DivisionInfo divisionInfo) {
        return divisionInfo.getDividend() < 0 ? 2 : 1;
    }
}
