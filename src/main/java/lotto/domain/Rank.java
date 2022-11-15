package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FAIL(0, false, 0, "0"),
    RANK5(3, false, 5_000, "5,000"),
    RANK4(4, false, 50_000, "50,000"),
    RANK3(5, false, 1_500_000, "1,500,000"),
    RANK2(5, true, 30_000_000, "30,000,000"),
    RANK1(6, false, 2_000_000_000, "2,000,000,000");

    private final int matchCount;
    private final boolean isBonusMatch;
    private final int price;
    private final String priceConvertString;
    
    Rank(final int matchCount, final boolean isBonusMatch, final int price,final String priceConvertString) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.price = price;
        this.priceConvertString = priceConvertString;
    }

    public static Rank of(final int matchCount, final boolean isBonusMatch) {
        return Arrays.stream(values())
            .filter(rank -> rank.isSameMatchCount(matchCount))
            .filter(rank -> !rank.equals(RANK2) || isBonusMatch)
            .findAny()
            .orElse(FAIL);
    }

    private boolean isSameMatchCount(final int matchCount) {
        return this.matchCount == matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }
    
    public int getPrice() {
        return this.price;
    }
    
    public String getPriceConvertString() {
    	return this.priceConvertString;
    }
}
