package lotto.utils;

public class Parser {
    public static int purchaseNum(String money) throws IllegalArgumentException {
        return Integer.parseInt(money)/1000;
    }
}
