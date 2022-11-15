package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public enum Ranking {
    FIRST(2000000000, 6),
    SECOND(30000000, 5),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3),
    DEFAULT(0, 0);

    private final int prize;
    private final int matchCount;

    Ranking(int prize, int matchCount){
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public static Ranking getRanking(boolean bonusBall, int matchCount){
        if(matchCount == THIRD.matchCount && !bonusBall){
            return THIRD;
        }

        if(matchCount < FIFTH.matchCount){
            return DEFAULT;
        }
        return Arrays.stream(values()).filter(Ranking -> Ranking.matchCount == matchCount)
                        .findAny()
                        .orElseThrow(NoSuchElementException::new);
    }

    public static List<Ranking> winningResults() {
        return Arrays.asList(FIFTH,FOURTH,THIRD, SECOND, FIRST);
    }
    public int getMatchCount(){
        return matchCount;
    }

    public int getPrize(){
        return prize;
    }
}
