import java.lang.reflect.Array;
import java.util.Arrays;

public class Years {
    private final int MINIMAL_YEAR = 2002; // минимальный стартовый год.
    private int startYear; // год, в который пользователь решил выйти на пенсию.

    //private double startYearInflation; // инфляция в стартовый год.
    private double startYearMOEX; // индекс биржи в стартовый год.
    private final int FINAL_YEAR = 2022; // год окончания пенсии, не включается в расчёты суммы.

    private int yearsCount; // количество годиков в диапазоне заданных констант MINIMAL_YEAR и FINAL_YEAR.

    private int startYearArrayIndex; // нужно чтобы дёргать из Constans значения за нужные года.



    public int getMINIMAL_YEAR() {
        return MINIMAL_YEAR;
    }
    public int getFINAL_YEAR() {
        return FINAL_YEAR;
    }
    public int getYearArrayIndex(){
        return startYearArrayIndex;
    }
    public int getYearsCount(){
        return yearsCount;
    }

    double getStartYearMOEX() {
        return startYearMOEX;
    }

    public void setStartYear(int year) {
        startYear = year;
    }
    public int getStartYear(){
        return startYear;
    }

    public void startYearParamSet () {
        if((FINAL_YEAR - MINIMAL_YEAR) - (FINAL_YEAR - startYear) != 0 ) {
            startYearArrayIndex = (FINAL_YEAR - MINIMAL_YEAR) - (FINAL_YEAR - startYear) - 1;
        } else startYearArrayIndex = (FINAL_YEAR - MINIMAL_YEAR) - (FINAL_YEAR - startYear);
        startYearMOEX = Constants.MOEX_RATE[startYearArrayIndex];
        yearsCount = FINAL_YEAR - MINIMAL_YEAR;
    }

}
