import java.lang.reflect.Array;
import java.util.Arrays;

public class Years {
    private final int MINIMAL_YEAR = 2002;
    private int startYear;
    private double startYearMOEX;
    private final int FINAL_YEAR = 2022;

    private int yearsCount;

    private int startYearArrayIndex;

    public int getYearArrayIndex() {
        return startYearArrayIndex;
    }

    public int getYearsCount() {
        return yearsCount;
    }

    double getStartYearMOEX() {
        return startYearMOEX;
    }

    public void setStartYear(int year) {
        startYear = year;
    }

    public void startYearParamSet() {
        int yrsCnt = FINAL_YEAR - MINIMAL_YEAR;
        int yrsDiff = FINAL_YEAR - startYear;

        if (yrsCnt - yrsDiff != 0) {
            startYearArrayIndex = yrsCnt - yrsDiff - 1;
        } else startYearArrayIndex = yrsCnt - yrsDiff;

        startYearMOEX = Constants.MOEX_RATE[startYearArrayIndex];
        yearsCount = FINAL_YEAR - MINIMAL_YEAR;
    }

}
