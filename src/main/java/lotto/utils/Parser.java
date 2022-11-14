package lotto.utils;

public class Parser {
    public int purchaseNum(String money) throws IllegalArgumentException {
        return Integer.parseInt(money)/1000;
    }
}
