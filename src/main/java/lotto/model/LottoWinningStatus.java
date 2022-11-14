package lotto.model;

import java.text.DecimalFormat;

public enum LottoWinningStatus {

    THREE_NUMBERS_MATCH(3, 5000L), FOUR_NUMBERS_MATCH(4, 50000L),
    FIVE_NUMBERS_MATCH(5, 1500000L), FIVE_NUMBERS_WITH_BONUS_NUMBER_MATCH(5, 30000000L),
    SIX_NUMBERS_MATCH(6, 2000000000L), NOT_WINNING_STATUS(0, 0);

    private static final int NUMBER_OF_MATCH_WITH_BONUS_NUMBER = 5;
    private final int numberOfMatch;
    private final long winningMoney;

    LottoWinningStatus(int numberOfMatch, long winningMoney) {
        this.numberOfMatch = numberOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getNumberOfMatch() {
        return numberOfMatch;
    }

    public long getWinningMoney() {
        return winningMoney;
    }

    public static LottoWinningStatus valueOf(int numberOfMatch, boolean hasBonusNumber) {
        if (numberOfMatch == NUMBER_OF_MATCH_WITH_BONUS_NUMBER) return valueOf(hasBonusNumber);
        for (LottoWinningStatus winningStatus : LottoWinningStatus.values()) {
            if (winningStatus.getNumberOfMatch() == numberOfMatch) {
                return winningStatus;
            }
        }
        return NOT_WINNING_STATUS;
    }

    private static LottoWinningStatus valueOf(boolean hasBonusNumber) {
        if (hasBonusNumber) return FIVE_NUMBERS_WITH_BONUS_NUMBER_MATCH;
        return FIVE_NUMBERS_MATCH;
    }

    @Override
    public String toString() {
        String bonusPhrase = "";
        DecimalFormat formatter = new DecimalFormat("###,###");
        if (this == FIVE_NUMBERS_WITH_BONUS_NUMBER_MATCH) bonusPhrase = ", 보너스 볼 일치";
        return numberOfMatch + "개 일치" + bonusPhrase + " (" + formatter.format(winningMoney) + "원)";
    }
}
