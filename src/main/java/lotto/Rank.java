package lotto;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2000000000, false,0),
    SECOND(5,3000000, true,0),
    THIRD(5, 1500000, false,0),
    FOURTH(4, 50000, false,0),
    FIFTH(3, 5000, false,0),
    NOTHING(0,0, false,0);


    private final int prize;
    private final int winNum;
    private final boolean bonus;
    private int count;

    Rank(int winNum, int prize, boolean bonus, int count) {
        this.prize = prize;
        this.winNum = winNum;
        this.bonus = bonus;
        this.count = count;
    }

    //개수로 랭크 판별
    public static Rank getRank(int matchedNumCnt,boolean isbonusMatched) {
        return Arrays.stream(values())
                .filter(rank -> rank.winNum == matchedNumCnt && rank.bonus == isbonusMatched)
                .findFirst()
                .orElse(NOTHING);
    }

    public int getPrize(){
        return prize;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
