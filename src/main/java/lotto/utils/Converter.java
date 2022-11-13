package lotto.utils;

public class Converter {
    public static int moneyToTicket(int money) {
        return money % 1000;
    }
}
