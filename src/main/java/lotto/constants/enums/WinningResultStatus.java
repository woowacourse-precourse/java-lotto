package lotto.constants.enums;

import java.util.List;
import lotto.constants.utils.WinningResultUtil;

public enum WinningResultStatus {
    FIRST(WinningResultUtil.FIRST_PLACE_COUNT, WinningResultUtil.FIRST_PRIZE),
    SECOND(WinningResultUtil.SECOND_PLACE_COUNT, WinningResultUtil.SECOND_PRIZE),
    THIRD(WinningResultUtil.THIRD_PLACE_COUNT, WinningResultUtil.THIRD_PRIZE),
    FOURTH(WinningResultUtil.FOURTH_PLACE_COUNT, WinningResultUtil.FOURTH_PRIZE),
    FIFTH(WinningResultUtil.FIFTH_PLACE_COUNT, WinningResultUtil.FIFTH_PRIZE),
    NOTHING(WinningResultUtil.NOTHING_PLACE_COUNT, WinningResultUtil.NOTHING_PRIZE);

    final int winCount;
    final long prizeMoney;

    WinningResultStatus(int winCount, long prizeMoney) {
        this.winCount = winCount;
        this.prizeMoney = prizeMoney;
    }

    public static WinningResultStatus getWinningResultStatus(int hitCount) {
        if (FIRST.winCount == hitCount) {
            return FIRST;
        }
        if (SECOND.winCount == hitCount) {
            return SECOND;
        }
        if (THIRD.winCount == hitCount) {
            return THIRD;
        }
        if (FOURTH.winCount == hitCount) {
            return FOURTH;
        }
        return FIFTH;
    }

    public static List<WinningResultStatus> getWinResultStatuses() {
        return List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
