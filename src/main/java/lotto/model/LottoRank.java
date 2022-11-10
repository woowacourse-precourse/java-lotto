package lotto.model;

import java.util.Arrays;

import static lotto.global.ExceptionConstants.*;

public enum LottoRank {

    FIRST(6, false, "6개 일치", 2_000_000_000),
    SECOND(5, true, "5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD(5, false, "5개 일치", 1_500_000),
    FOURTH(4, false, "4개 일치", 50_000),
    FIFTH(3, false, "3개 일치", 5_000);

    private final long count;
    private final boolean bounsFlag;
    private final String description;
    private final long reward;

    LottoRank(long count, boolean bounsFlag, String description, long reward) {
        this.count = count;
        this.bounsFlag = bounsFlag;
        this.description = description;
        this.reward = reward;
    }

    public static LottoRank getRank(int matchingCount, boolean bounsFlag) {
        return Arrays.stream(values())
                     .filter(lottoRank -> lottoRank.count == matchingCount)
                     .filter(lottoRank -> lottoRank.bounsFlag == bounsFlag)
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException(LESS_THAN_THREE_MATCHING_NUMBER));
    }

    public String getDescription() {
        return description;
    }

    public long getReward() {
        return reward;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append(description)
                            .append(" (")
                            .append(reward)
                            .append(") ")
                            .append("- ")
                            .toString();
    }
}
