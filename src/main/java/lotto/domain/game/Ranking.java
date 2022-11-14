package lotto.domain.game;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    DEFAULT(0, false, 0);

    private int count;
    private boolean matchBonusNumber;
    private long prize;

    Ranking(int count, boolean matchBonusNumber, long prize){
        this.count = count;
        this.matchBonusNumber = matchBonusNumber;
        this.prize = prize;
    }

    public static Ranking findRanking(int count, boolean matchBonusNumber){
        return Arrays.stream(Ranking.values()).filter(ranking -> ranking.count == count && ranking.matchBonusNumber == matchBonusNumber)
                .findAny().orElse(DEFAULT);
    }

    public int getCount(){
        return count;
    }

    public boolean getMatchBonusNumber(){
        return matchBonusNumber;
    }

    public long getPrize(){
        return prize;
    }
}
