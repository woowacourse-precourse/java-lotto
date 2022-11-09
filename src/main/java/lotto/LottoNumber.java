package lotto;

public class LottoNumber {
    public LottoNumber() {
        Money money = new Money();
    }

    private int computeLottoNumber(int money) {
        final int LOTTO_SELLING_PRICE = 1000;

        return money / LOTTO_SELLING_PRICE;
    }
}
