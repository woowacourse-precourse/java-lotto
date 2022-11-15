package lotto.constants.enums;

import java.util.List;
import lotto.constants.utils.WinResultUtil;

public enum WinResultStatus {
    FIRST(WinResultUtil.FIRST_PLACE_COUNT, WinResultUtil.FIRST_PRIZE),
    SECOND(WinResultUtil.SECOND_PLACE_COUNT, WinResultUtil.SECOND_PRIZE),
    THIRD(WinResultUtil.THIRD_PLACE_COUNT, WinResultUtil.THIRD_PRIZE),
    FOURTH(WinResultUtil.FOURTH_PLACE_COUNT, WinResultUtil.FOURTH_PRIZE),
    FIFTH(WinResultUtil.FIFTH_PLACE_COUNT, WinResultUtil.FIFTH_PRIZE),
    NOTHING(WinResultUtil.NOTHING_PLACE_COUNT, WinResultUtil.NOTHING_PRIZE);

    final int winCount;
    final long prizeMoney;

    WinResultStatus(int winCount, long prizeMoney) {
        this.winCount = winCount;
        this.prizeMoney = prizeMoney;
    }

    public static WinResultStatus getWinResultStatus(int hitCount) {
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

    public static List<WinResultStatus> getWinResultStatuses() {
        return List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
