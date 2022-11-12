package lotto.domain;

import java.util.List;

public enum WinningPrice {
   FIRST("2,000,000,000원", 6, false),
    SECOND("30,000,000원", 5, true),
    THIRD("1,500,000원", 5, false),
    FOURTH("50,000원", 4, false),
    FIFTH("5,000원", 3, false);

    private final String price;
    private final int accordedNumber;
    private final boolean shouldHitBonus;

    WinningPrice(final String price, int accordedNumber, boolean shouldHitBonus) {
       this.price = price;
       this.accordedNumber = accordedNumber;
       this.shouldHitBonus = shouldHitBonus;
    }

    public String getPrice() {
        return this.price;
    }
    public int getAccordedNumber() { return this.accordedNumber; }
    public boolean shouldHitBonus() { return this.shouldHitBonus; }

    public int countMatchResult(List<Result> results) {
        return (int) results.stream()
                .filter(result -> isSameAsThis(result))
                .count();
    }

    private boolean isSameAsThis(Result result) {
        return result.getAccordedNumbers() == accordedNumber &&
                result.isHitBonus() == shouldHitBonus;
    }
}
