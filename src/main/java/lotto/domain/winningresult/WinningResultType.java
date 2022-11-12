package lotto.domain.winningresult;

import java.util.Arrays;

public enum WinningResultType {
    FIFTH_PLACE(3,"3개 일치", 5_000),
    FOURTH_PLACE(4,"4개 일치", 50_000),
    THIRD_PLACE(5,"5개 일치", 1_500_000),
    SECOND_PLACE(5,"5개 일치, 보너스 볼 일치", 30_000_000),
    FIRST_PLACE(6,"6개 일치", 2_000_000_000);

    private int matchedCount;
    private String content;
    private int reward;

    WinningResultType(int matchedCount, String content, int reward) {
        this.matchedCount = matchedCount;
        this.content = content;
        this.reward = reward;
    }

    public static WinningResultType of(int matchedCount, boolean isBonusMatched) {
        if (isBonusMatched && matchedCount == 5) {
            return SECOND_PLACE;
        }

        return Arrays.stream(values())
                .filter(result -> matchedCount == result.matchedCount)
                .findFirst()
                .orElseThrow();
    }
}
