package lotto.domain;

public enum WinningLotto {
    PLACE_1(6, false, new Money(2_000_000_000)),
    PLACE_2(5, true, new Money(30_000_000)),
    PLACE_3(5, false, new Money(1_500_000)),
    PLACE_4(4, true, new Money(50_000)),
    PLACE_5(3, false, new Money(5_000));

    private final int commonMatch;
    private final boolean bonusMatch;
    private final Money money;

    WinningLotto(int commonMatch, boolean bonusMatch, Money money) {
        this.commonMatch = commonMatch;
        this.bonusMatch = bonusMatch;
        this.money = money;
    }

    private boolean isEqualElement(int commonMatch, boolean bonusMatch) {
        return this.commonMatch == commonMatch && this.bonusMatch == bonusMatch;
    }

    public int getCommonMatch() {
        return commonMatch;
    }

    public int getMoneyValue() {
        return money.intValue();
    }

}
