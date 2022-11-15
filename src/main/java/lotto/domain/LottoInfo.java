package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoInfo {
    BLANK(0, 0, 0),
    FIRST_PLACE(1, 6, 2000000000),
    SECOND_PLACE(2, 5, 30000000),
    THIRD_PLACE(3, 5, 1500000),
    FOURTH_PLACE(4, 4, 50000),
    FIFTH_PLACE(5, 3, 5000);

    public static final Map<Integer, LottoInfo> price = new HashMap<>(){
        {
            put(0, BLANK);
            put(1, FIRST_PLACE);
            put(2, SECOND_PLACE);
            put(3, THIRD_PLACE);
            put(4, FOURTH_PLACE);
            put(5, FIFTH_PLACE);
        }
    };
    private final int winning;
    private final int matchCount;
    private final int winningPrize;

    LottoInfo(int winning, int matchCount, int winningPrize) {
        this.winning = winning;
        this.matchCount = matchCount;
        this.winningPrize = winningPrize;
    }

    public int getWinning() {
        return winning;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrize() {
        return winningPrize;
    }
}
