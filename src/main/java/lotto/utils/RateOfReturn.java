package lotto.utils;

public class RateOfReturn {
    public String RateOfReturn(int revenue, int money) {
        return String.format("%.1f",revenue/money*100);
    }
}
