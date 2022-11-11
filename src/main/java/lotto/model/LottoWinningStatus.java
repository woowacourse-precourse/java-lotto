package lotto.model;

import java.text.DecimalFormat;

public enum LottoWinningStatus {

    MATCH_THREE_NUMBERS(3, 5000L), MATCH_FOUR_NUMBERS(4, 50000L),
    MATCH_FIVE_NUMBERS(5, 1500000L), MATCH_FIVE_NUMBERS_WITH_BONUS_NUMBERS(5, 30000000L),
    MATCH_SIX_NUMBERS(6, 2000000000L);

    private final int numberOfMatch;
    private final long winningMoney;

    LottoWinningStatus(int numberOfMatch, long winningMoney) {
        this.numberOfMatch = numberOfMatch;
        this.winningMoney = winningMoney;
    }

    @Override
    public String toString() {
        String bonusPhrase = "";
        DecimalFormat formatter = new DecimalFormat("###,###");
        if (this == MATCH_FIVE_NUMBERS_WITH_BONUS_NUMBERS) bonusPhrase = ", 보너스 볼 일치";
        return numberOfMatch + "개 일치" + bonusPhrase + " (" + formatter.format(winningMoney) + "원)";
    }

    public int getNumberOfMatch() {
        return numberOfMatch;
    }

    public long getWinningMoney() {
        return winningMoney;
    }
}
