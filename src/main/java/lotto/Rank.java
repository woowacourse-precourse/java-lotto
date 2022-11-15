package lotto;

import java.util.Arrays;

public enum Rank {
    NOTHING(0,0),
    FIFTH(3, 0),
    FOURTH(4, 0),
    THIRD(5, 0),
    SECOND(5, 1),
    FIRST(6, 0);

    private long winLottoCount;
    private long winBonusCount;

    Rank(long winLottoCount, long winBonusCount) {
        this.winLottoCount = winLottoCount;
        this.winBonusCount = winBonusCount;
    }

    public long winLottoCount() {
        return winLottoCount;
    }

    public long winBonusCount() {
        return winBonusCount;
    }

    public static Rank valueOfLottoCount(long winLottoCount) {
        return Arrays.stream(values())
                .filter(value -> value.winLottoCount == winLottoCount).findAny()
                .orElse(NOTHING);
    }
}
