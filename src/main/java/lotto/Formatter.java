package lotto;

public class Formatter {
    public static int convertStringToNumber(String string) {
        Validator.checkConvertibleStringToNumber(string);
        return Integer.parseInt(string);
    }

    public static int[] convertStringToNumbers(String string) {
        String[] strings = string.split(",");
        int[] numbers = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            numbers[i] = convertStringToNumber(strings[i]);
        }
        return numbers;
    }
}
