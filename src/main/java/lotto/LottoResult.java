package lotto;

import static lotto.LottoWinnings.*;

public class LottoResult {
    private int numberMatchCount;
    private boolean isBonusNumberMatch;
    private Long winnings;

    public LottoResult(int numberMatchCount, boolean isBonusNumberMatch) {
        this.numberMatchCount = numberMatchCount;
        this.isBonusNumberMatch = isBonusNumberMatch;
        this.winnings = saveWinnings();
    }

    private Long saveWinnings() {
        if (numberMatchCount == 6) {
            return LOTTO_6_NUMBERS_MATCH.getWinnings();
        }

        if (numberMatchCount == 5 && isBonusNumberMatch) {
            return LOTTO_5_NUMBERS_AND_BONUS_NUMBER_MATCH.getWinnings();
        }

        if (numberMatchCount == 5) {
            return LOTTO_5_NUMBERS_MATCH.getWinnings();
        }

        if (numberMatchCount == 4) {
            return LOTTO_4_NUMBERS_MATCH.getWinnings();
        }

        if (numberMatchCount == 3) {
            return LOTTO_3_NUMBERS_MATCH.getWinnings();
        }

        return LOTTO_UNDER_3_NUMBERS_MATCH.getWinnings();
    }

    public int getNumberMatchCount() {
        return numberMatchCount;
    }

    public boolean isBonusNumberMatch() {
        return isBonusNumberMatch;
    }

    public Long getWinnings() {
        return winnings;
    }
}
