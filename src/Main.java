import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static double maxPercent;

    public static void main(String[] args) throws Exception {
        Validation validation = new Validation();
        Money money = new Money();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Привет!" + '\n' + "1.  Введи год от 2002 до 2021, с которого хочешь чиллить, "
                + "и я расскажу тебе сколько нужно снимать в % чтобы не жрать дошик."
                + "\n2.  Убедительная просьба год вводить полностью цифрами, без проблелов."
                + "\n2.1 Например: \"2002\".");
        String inputYear = reader.readLine();
        validation.okOrNot(inputYear);
        money.setParams(Integer.parseInt(inputYear));
        money.maxPercentChange();


    }
}