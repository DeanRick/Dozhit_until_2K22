public class Validation {

    void okOrNot(String year) throws Exception {
        String regex = "\\d+";

        if (year == null || year.isEmpty()) {
            throw new Exception("Вы ничего не ввели. Введите год начала пенсии.");
        }

        if (!year.matches(regex)) {
            throw new Exception("Год нужно вводить циферками, глупый валерка. Попробуй ещё раз.");
        }

        if (Integer.parseInt(year) <= 2001 || Integer.parseInt(year) >= 2022) {
            throw new Exception("Нужно ввести значение от 2002 до 2021.");
        }

    }


}
