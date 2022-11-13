package lotto;

public enum LottoRank {
    FIFTH_PLACE(5000, 3, false),
    FOURTH_PLACE(50000, 4, false),
    THIRD_PLACE(1500000, 5, false),
    SECOND_PLACE(30000000, 5, true),
    FIRST_PLACE(2000000000, 6, false);

    public final int price;
    public final int matchNumberCount;
    public final boolean hasBonusNumber;

    LottoRank(int price, int matchNumberCount, boolean hasBonusNumber) {
        this.price = price;
        this.matchNumberCount = matchNumberCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public boolean matchLottoRank(int matchNumberCount, boolean hasBonusNumber) {
        return this.matchNumberCount == matchNumberCount && this.hasBonusNumber == hasBonusNumber;
    }
}
