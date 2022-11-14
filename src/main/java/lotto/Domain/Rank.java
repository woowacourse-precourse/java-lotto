package lotto.Domain;

import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5,30000000),
    THRID(5,1500000),
    FIRTH(4,50000),
    FIFTH(3,5000),
    NONE(-1,0);

    private int equalNumber;
    private int prizeMoney;

    Rank(int equalNumber, int prizeMoney) {
        this.equalNumber = equalNumber;
        this.prizeMoney = prizeMoney;
    }

    public static Rank findRank(int equalNumber,boolean hasBonusNumber){
        if(equalNumber== THRID.equalNumber && !hasBonusNumber){
            return THRID;
        }
        return Stream.of(values())
                .filter(rank -> rank.equalNumber == equalNumber)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
    public int getRank() {
        return equalNumber;
    }
}
