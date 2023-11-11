public class Money {

    Years years = new Years();
    private double maxPercent;
    private double startPercent = 0.005;

    public void setMaxPercent(double percent) {
        this.maxPercent = percent;
    }
    public double getMaxPercent(){
        return maxPercent;
    }

    private void stillAlive(){
        startPercent +=0.005;
        maxPercentChange();
    }

    public void setParams(int year){
        years.setStartYear(year);
        years.startYearParamSet();
    }
    public void maxPercentChange(){

        double startCapital = years.getStartYearMOEX() ;
        double capitalСhange = 0;
        double startPercentUp = 0;
        int fullCycle = 0;
        for(int i = years.getYearArrayIndex(); i < years.getYearsCount()-1; i++){
            if(i == years.getYearArrayIndex()){
               capitalСhange = Constants.MOEX_RATE[years.getYearArrayIndex()];
               startPercentUp = startPercent;
            }
            // вычитаем зарплату вначале года
            capitalСhange = capitalСhange - (startCapital * startPercentUp);
            // если капитал ушёл в минус и до этого были успешные циклы с положительным капиталом - меняем %
            // на предыдущий и выводим как максимальный.
            if(capitalСhange < 0 || Double.valueOf(startCapital).equals(0) && fullCycle >= 1){
                Main.maxPercent = startPercent - 0.005;
                System.out.println("Максимальный % изъятия = " + String.format("%.1f",Main.maxPercent*100));
                break;
            }
            // считаем прибыль в конце года.
            capitalСhange = (capitalСhange / (Constants.MOEX_RATE[i] / Constants.MOEX_RATE[years.getYearArrayIndex()])) * (Constants.MOEX_RATE[i+1] / Constants.MOEX_RATE[years.getYearArrayIndex()]);
            // увеличиваем изымаемый % на инфляцию.
            startPercentUp = startPercentUp + (startPercentUp*(Constants.INFLATION_RATE[i]/100));




            if (capitalСhange > 0 && i == years.getYearsCount()-2){
                stillAlive();
                fullCycle++;
                break;
            }
        }


    }

}
