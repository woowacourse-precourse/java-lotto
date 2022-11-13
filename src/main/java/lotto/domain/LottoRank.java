package lotto.domain;

import java.lang.reflect.Array;
import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30_000_000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1_500_000,"5개 일치 (1,500,000원) - "),
    FOURTH(4,50_000, "4개 일치 (50,000원) - "),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    FAILED(0,0,"");

    private final int winningNumberCount;
    private final int rewardMoney;
    private final String resultMessage;

    LottoRank(int winningNumberCount, int rewardMoney, String resultMessage) {
        this.winningNumberCount = winningNumberCount;
        this.rewardMoney = rewardMoney;
        this.resultMessage = resultMessage;
    }

    public static LottoRank getLottoRank(int winningNumberCount, boolean bonusNumber) {
        if (winningNumberCount == SECOND.winningNumberCount && bonusNumber) {
            return SECOND;
        }
        return Arrays.stream(LottoRank.values())
                .filter(LottoRank -> LottoRank.winningNumberCount == winningNumberCount)
                .findFirst()
                .orElse(FAILED);
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
