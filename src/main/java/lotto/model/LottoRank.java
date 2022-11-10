package lotto.model;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum LottoRank {

    FIRST(6, false, "6개 일치", 2_000_000_000),
    SECOND(5, true, "5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD(5, false, "5개 일치", 1_500_000),
    FOURTH(4, false, "4개 일치", 50_000),
    FIFTH(3, false, "3개 일치", 5_000),
    NONE(1, false, "실패", 0);

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
                     .orElse(NONE);
    }

    public String getDescription() {
        return description;
    }

    public long getReward() {
        return reward;
    }

    public long getCount() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        DecimalFormat formatter = new DecimalFormat("###,###");

        return stringBuilder.append(description)
                            .append(" (")
                            .append(formatter.format(reward))
                            .append("원")
                            .append(") ")
                            .append("- ")
                            .toString();
    }
}
