package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.view.Constants.*;

public enum Prize {
    FIFTH(5_000, 3, false, SAME_THREE),
    FOURTH(50_000, 4, false, SAME_FOUR),
    THIRD(1_500_000, 5, false, SAME_FIVE),
    SECOND(30_000_000, 5, true, SAME_FIVE_BONUS),
    FIRST(2_000_000_000, 6, false, SAME_SIX);

    private final int prizeMoney;
    private final int sameCount;
    private final boolean acceptBonus;
    private final String prizeNotice;

    Prize(int prizeMoney, int sameCount, boolean acceptBonus, String prizeNotice) {
        this.prizeMoney = prizeMoney;
        this.sameCount = sameCount;
        this.acceptBonus = acceptBonus;
        this.prizeNotice = prizeNotice;
    }

    private int getPrizeMoney() { return prizeMoney; }
    private int getSameCount() { return sameCount; }
    private boolean getAcceptBonus() { return acceptBonus; }
    private String getPrizeNotice() { return prizeNotice; }

    public static List<Integer> getMoneyValues() {
        return Stream.of(Prize.values())
                .map(Prize::getPrizeMoney)
                .collect(Collectors.toList());
    }

    public static List<Integer> getSameValues() {
        return Stream.of(Prize.values())
                .map(Prize::getSameCount)
                .collect(Collectors.toList());
    }

    public static List<Boolean> getBonusValues() {
        return Stream.of(Prize.values())
                .map(Prize::getAcceptBonus)
                .collect(Collectors.toList());
    }

    public static List<String> getNoticeValues() {
        return Stream.of(Prize.values())
                .map(Prize::getPrizeNotice)
                .collect(Collectors.toList());
    }
}
