package lotto;

public class LottoNumber {
    private final int number;

    public LottoNumber() {
        Money money = new Money();
        this.number = computeLottoNumber(money.getMoney());
    }

    private int computeLottoNumber(int money) {
        final int LOTTO_SELLING_PRICE = 1000;

        return money / LOTTO_SELLING_PRICE;
    }

    public int getLottoNumber() {
        return this.number;
    }
}
