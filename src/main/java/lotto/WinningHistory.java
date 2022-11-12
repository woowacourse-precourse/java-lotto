package lotto;

import java.util.Arrays;

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

    public static WinningHistory getWinningHistoryType(int matchNumbers, boolean matchBonus) {
        return Arrays.stream(WinningHistory.values())
                .filter(rankData -> rankData.isRankData(rankData, matchNumbers, matchBonus))
                .findAny().orElse(BLANK);
    }

    private boolean isRankData(WinningHistory rankData, int matchNumbers, boolean matchBonus) {
        if (isSecondPrize(rankData) && isSameSecondPrizeData(matchNumbers, matchBonus)) {
            return matchNumberWithoutBonus(rankData.matchNumbers, matchNumbers);
        } else if (!rankData.isSecondPrize(rankData) && !rankData.isSameSecondPrizeData(matchNumbers, matchBonus)) {
            return matchBonus && matchNumberWithBonus(this.matchNumbers, matchNumbers)
                    || matchNumberWithoutBonus(this.matchNumbers, matchNumbers);
        }

        return false;
    }

    private boolean isSecondPrize(WinningHistory rankData) {
        return rankData == SECOND_PRIZE;
    }

    private boolean isSameSecondPrizeData(int matchNumbers, boolean matchBonus) {
        return matchBonus && (matchNumbers == SECOND_PRIZE.getMatchNumbers());
    }

    private boolean matchNumberWithBonus(int winningMatchNumbers, int matchNumbers) {
        return winningMatchNumbers == matchNumbers + 1;
    }

    private boolean matchNumberWithoutBonus(int winningMatchNumbers, int matchNumbers) {
        return winningMatchNumbers == matchNumbers;
    }
}
