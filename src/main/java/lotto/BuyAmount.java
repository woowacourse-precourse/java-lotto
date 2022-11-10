package lotto;

public class BuyAmount {
    int buyLotto;

    public BuyAmount(int money) {
        buyLotto = divideBy(money);
    }

    private int divideBy(int money) {
        if (money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 구입할 수 있습니다.");

        return money / 1000;
    }

}
