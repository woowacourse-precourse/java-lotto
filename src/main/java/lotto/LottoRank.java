package lotto;

public enum LottoRank {
    FIRST_PLACE(2000000000, 6, false),
    SECOND_PLACE(30000000, 5, true),
    THIRD_PLACE(1500000, 5, false),
    FOURTH_PLACE(50000, 4, false),
    FIFTH_PLACE(5000, 3, false);

    final int price;
    final int matchNumberCount;
    final boolean hasBonusNumber;

    LottoRank(int price, int matchNumberCount, boolean hasBonusNumber) {
        this.price = price;
        this.matchNumberCount = matchNumberCount;
        this.hasBonusNumber = hasBonusNumber;
    }
}
