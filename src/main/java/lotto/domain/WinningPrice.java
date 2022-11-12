package lotto.domain;

import java.util.List;

public enum WinningPrice {
   FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false);

    private final int price;
    private final int accordedNumber;
    private final boolean shouldHitBonus;

    WinningPrice(final int price, int accordedNumber, boolean shouldHitBonus) {
       this.price = price;
       this.accordedNumber = accordedNumber;
       this.shouldHitBonus = shouldHitBonus;
    }

    public int getPrice() {
        return this.price;
    }
    public int getAccordedNumber() { return this.accordedNumber; }
    public boolean shouldHitBonus() { return this.shouldHitBonus; }

    public int countMatchResult(List<Result> results) {
        return (int) results.stream()
                .filter(result -> isSameAsThis(result))
                .count();
    }

    public boolean isSameAsThis(Result result) {
        return result.getAccordedNumbers() == accordedNumber &&
                result.isHitBonus() == shouldHitBonus;
    }
}
