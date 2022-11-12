package lotto.utils;

public class Parser {
    public static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public static int countLotto(int amount) {
        return (int) amount / 1000;
    }
}
