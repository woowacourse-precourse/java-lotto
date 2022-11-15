package lotto;

import java.util.List;

public enum Rank {
    FIRST(4, 6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(3, 5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(2, 5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(1, 4, false, 50_000, "4개 일치 (50,000원) - "),
    FIFTH(0, 3, false, 5_000, "3개 일치 (5,000원) - ");

    public final static int MAX_RANK = 5;
    public final static List<Rank> RANK_ASC = List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    private final int index;
    private final int matchCount;
    private final boolean hasBonusNumber;
    private final int reward;
    private final String message;

    Rank(int index, int matchCount, boolean hasBonusNumber, int reward, String message) {
        this.index = index;
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.reward = reward;
        this.message = message;
    }

    public int getIndex() {
        return index;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getHasBonusNumber() {
        return hasBonusNumber;
    }

    public int getReward() {
        return reward;
    }

    public String getMessage() {
        return message;
    }
}
