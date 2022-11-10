package lotto.domain;

public class LottoCount {

    public int getLottoCount(int money) {
        return getMoney(money);
    }

    private int getMoney(int money) {
        if (money % 1000 == 0) {
            money /= 1000;
        }
        return money;
    }
}
