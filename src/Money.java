public class Money {

    Years years = new Years();
    private double startPercent = 0.005;
    int fullCycle = 0;

    private void stillAlive() {
        startPercent += 0.005;
        maxPercentChange();
    }

    public void setParams(int year) {
        years.setStartYear(year);
        years.startYearParamSet();
    }

    public void maxPercentChange() {

        double startCapital = years.getStartYearMOEX();
        double capitalСhange = 0;
        double startPercentUp = 0;


        for (int i = years.getYearArrayIndex(); i < years.getYearsCount() - 1; i++) {
            double coeffThisYear = Constants.MOEX_RATE[i] / Constants.MOEX_RATE[years.getYearArrayIndex()];
            double coeffNextYear = Constants.MOEX_RATE[i + 1] / Constants.MOEX_RATE[years.getYearArrayIndex()];
            if (i == years.getYearArrayIndex()) {
                capitalСhange = Constants.MOEX_RATE[years.getYearArrayIndex()];
                startPercentUp = startPercent;
            }

            capitalСhange = capitalСhange - (startCapital * startPercentUp);

            if (capitalСhange < 0 && fullCycle >= 1) {
                Main.maxPercent = startPercent - 0.005;
                System.out.println("Максимальный % изъятия = " + String.format("%.1f", Main.maxPercent * 100));
                break;
            }

            capitalСhange = capitalСhange / coeffThisYear * coeffNextYear;
            startPercentUp = startPercentUp + (startPercentUp * (Constants.INFLATION_RATE[i] / 100));


            if (capitalСhange > 0 && i == years.getYearsCount() - 2) {
                fullCycle++;
                stillAlive();
                break;
            }
        }


    }

}
