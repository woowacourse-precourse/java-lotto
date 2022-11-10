package lotto.domain;

public class NumberOfLottos {

    private static final int MIN_PRICE_AMOUNT = 1000;

    public NumberOfLottos() {
    }

    public int calculateNumberOfLottos(int price) {
        return price / MIN_PRICE_AMOUNT;
    }
}