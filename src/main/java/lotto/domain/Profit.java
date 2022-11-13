package lotto.domain;

public class Profit {
    private int calculateRate(int purchaseAmount, int prizeMoney) {
        return (prizeMoney / purchaseAmount) * 100;
    }
}
