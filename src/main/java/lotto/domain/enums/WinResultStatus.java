package lotto.domain.enums;

import java.util.Arrays;

public enum WinResultStatus {
    NOTHING(0L, 0, "당첨 아님", false),
    FIFTH_WINNING(5_000L, 3, "3개 일치 (5,000원) - %d개", false),
    FOURTH_WINNING(50_000L, 4, "4개 일치 (50,000원) - %d개", false),
    THIRD_WINNING(1_500_000L, 5, "5개 일치 (1,500,000원) - %d개", false),
    SECOND_WINNING(30_000_000L, 5, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", true),
    FIRST_WINNING(2_000_000_000L, 6, "6개 일치 (2,000,000,000원) - %d개", false);

    private final Long winPrice;
    private final int winCount;
    private final String winMessage;
    private final boolean needBonus;

    WinResultStatus(final Long winPrice, final int winCount, final String winMessage, final boolean needBonus) {
        this.winPrice = winPrice;
        this.winCount = winCount;
        this.winMessage = winMessage;
        this.needBonus = needBonus;
    }

    public static WinResultStatus findResult(final int equalCount, final boolean needBonus) {
        if (equalCount == SECOND_WINNING.winCount && needBonus == SECOND_WINNING.needBonus) {
            return SECOND_WINNING;
        }
        return Arrays.stream(WinResultStatus.values())
                .filter(winResultStatus -> winResultStatus.winCount == equalCount)
                .findFirst()
                .orElse(NOTHING);
    }

    public String getMessage() {
        return this.winMessage;
    }

    public long getWinPrice() {
        return winPrice;
    }
}
