package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningHistory {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 30_000_000),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000),
    BLANK(2, 0);

    private final int matchNumbers;
    private final int prizeMoney;

    WinningHistory(int matchNumbers, int prizeMoney) {
        this.matchNumbers = matchNumbers;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static List<WinningHistory> getValues() {
        List<WinningHistory> winningHistoryValues = Stream.of(WinningHistory.values()).filter(rankType -> rankType.matchNumbers >= 3).collect(Collectors.toList());
        Collections.reverse(winningHistoryValues);
        return winningHistoryValues;
    }

    public static WinningHistory getWinningHistoryType(int matchNumbers, boolean matchBonus) {
        return Arrays.stream(WinningHistory.values())
                .filter(rankData -> rankData.isRankData(rankData, matchNumbers, matchBonus))
                .findAny().orElse(BLANK);
    }

    private boolean isRankData(WinningHistory rankData, int matchNumbers, boolean matchBonus) {
        if (isSecondPrize(rankData) && matchBonus) {
            return isMatchNumber(rankData.matchNumbers, matchNumbers);
        } else if (isThirdPrize(rankData) && !matchBonus) {
           return isMatchNumber(rankData.matchNumbers, matchNumbers);
        } else if (!isSecondPrize(rankData) && !isThirdPrize(rankData)) {
            return isMatchNumber(rankData.matchNumbers, matchNumbers);
        }

        return false;
    }

    private boolean isSecondPrize(WinningHistory rankData) {
        return rankData == SECOND_PRIZE;
    }

    private boolean isThirdPrize(WinningHistory rankData) {
        return rankData == THIRD_PRIZE;
    }

    private boolean isMatchNumber(int rankMatchNumbers, int matchNumbers) {
        return rankMatchNumbers == matchNumbers;
    }

    public String getStaticsMessage(int count) {
        if (isSecondPrize(matchNumbers, prizeMoney)) {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개", matchNumbers, prizeMoney, count);
        }

        return String.format("%d개 일치 (%,d원) - %,d개", matchNumbers, prizeMoney, count);
    }

    private boolean isSecondPrize(int matchNumbers, int prizeMoney) {
        return matchNumbers == SECOND_PRIZE.getMatchNumbers() && prizeMoney == SECOND_PRIZE.getPrizeMoney();
    }
}
