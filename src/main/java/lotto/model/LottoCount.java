package lotto.model;

public class LottoCount {
    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    public LottoCount(int amount) {
        this.amount = amount;
    }

    public int calculateLottoCount(){
        return amount / LOTTO_PRICE;
    }
}
