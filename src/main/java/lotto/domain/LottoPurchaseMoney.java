package lotto.domain;

public class LottoPurchaseMoney {
    private static final int LOTTO_PRICE = 1000;

    private final int autoDrawAmount;

    public LottoPurchaseMoney(String money) {
        int krw = Integer.parseInt(money);
        this.autoDrawAmount = krw;
    }

    public int getLottoAmount() {
        return autoDrawAmount;
    }

    public int getInvestMoney() {
        return (autoDrawAmount) * LOTTO_PRICE;
    }

    public int getAutoDrawAmount() {
        return autoDrawAmount;
    }
}
