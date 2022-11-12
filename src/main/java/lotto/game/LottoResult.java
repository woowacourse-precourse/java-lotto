package lotto.game;

public enum LottoResult {

    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    ERROR(-1);


    private final int amount;

    private LottoResult(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
