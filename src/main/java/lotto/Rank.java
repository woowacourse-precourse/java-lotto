package lotto;

import java.util.Arrays;

public enum Rank {
    first(6),
    second(5,true),
    third(5),
    fourth(4),
    fifth(3),
    꽝(0);

    private int correctCount;
    private boolean isBonusCorrect;

    private Rank(int correctCount) {
        this.correctCount=correctCount;
    }

    private Rank(int correctCount, boolean isBonusCorrect) {
        this.correctCount=correctCount;
        this.isBonusCorrect=isBonusCorrect;
    }
    public static Rank getRank(int correctCount){
        return Arrays.stream(Rank.values())
                .filter(x->x.correctCount==correctCount)
                .findAny()
                .orElse(꽝);
    }

    public static Rank getRank(int correctCount, boolean isBonusCorrect){
        return Arrays.stream(Rank.values())
                .filter(x->x.correctCount==correctCount&& x.isBonusCorrect==isBonusCorrect)
                .findAny()
                .orElse(꽝);
    }
}
