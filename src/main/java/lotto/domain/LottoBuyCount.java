package lotto.domain;

public class LottoBuyCount {
    private final int count;

    public LottoBuyCount(Money money) {
        this.count = countLottoByMoney(money);
    }

    private int countLottoByMoney(Money money) {
        int amount = money.getMoney();
        return (amount / 1000);
    }

    public int getCount() {
        return this.count;
    }
}
