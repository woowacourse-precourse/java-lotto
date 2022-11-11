package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.view.Constants.*;

public enum Prize {
    FIFTH(5_000, SAME_THREE),
    FOURTH(50_000, SAME_FOUR),
    THIRD(1_500_000, SAME_FIVE),
    SECOND(30_000_000, SAME_FIVE_BONUS),
    FIRST(2_000_000_000, SAME_SIX);

    private final int prizeMoney;
    private final String prizeNotice;

    Prize(int prizeMoney, String prizeNotice) {
        this.prizeMoney = prizeMoney;
        this.prizeNotice = prizeNotice;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getPrizeNotice() {
        return prizeNotice;
    }

    public static List<Integer> getMoneyValues() {
        return Stream.of(Prize.values())
                .map(Prize::getPrizeMoney)
                .collect(Collectors.toList());
    }

    public static List<String> getNoticeValues() {
        return Stream.of(Prize.values())
                .map(Prize::getPrizeNotice)
                .collect(Collectors.toList());
    }
}
