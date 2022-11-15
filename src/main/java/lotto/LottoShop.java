package lotto;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;
    private int money;

    public LottoShop(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if(money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int LottoCountCalculate() {
        int LottoCount = money / LOTTO_PRICE;
        return LottoCount;
    }
}
