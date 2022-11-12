package lotto.domain;

public class BuyLotto {
    public static final int LOTTO_PRICE = 1000;
    int price;

    public BuyLotto(int price) {
        this.price = price;

    }

    private int numberOfLotto() {
        return price / LOTTO_PRICE;
    }


}
