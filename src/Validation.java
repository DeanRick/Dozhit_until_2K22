public class Validation {
    private String regex = "\\d+";
    void okOrNot(String year) throws Exception {
        // проверяем что строка не пустая.
        if (year == null || year.length() == 0) {
            throw new Exception("Вы ничего не ввели. Введите год начала пенсии.");
        }
        // проверяем, что введены только цифры.
        if (!year.matches(regex)) {
            throw new Exception("Год нужно вводить циферками, глупый валерка. Попробуй ещё раз.");
        }
        // проверяем, что введены только значения из диапазона.
        if (Integer.parseInt(year) <= 2001 || Integer.parseInt(year) >= 2022) {
            throw new Exception("Нужно ввести значение от 2002 до 2021.");
        }

    }


}
