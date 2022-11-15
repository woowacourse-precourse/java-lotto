package lotto.Domain;

import java.util.stream.Stream;

public enum Rank {
    FIRST(1,6, 2_000_000_000),
    SECOND(2,5,30000000),
    THRID(3,5,1500000),
    FIRTH(4,4,50000),
    FIFTH(5,3,5000),
    NONE(6,-1,0);

    private final int rank;
    private final int equalNumber;
    private final int prizeMoney;

    Rank(int rank, int equalNumber, int prizeMoney) {
        this.rank = rank;
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
        return rank;
    }
}
