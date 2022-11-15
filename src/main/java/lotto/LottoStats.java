package lotto;

import static lotto.LottoWinnings.*;

public class LottoStats {
    private int countOf3NumbersMatch = 0;
    private int countOf4NumbersMatch = 0;
    private int countOf5NumbersMatch = 0;
    private int countOf5NumbersAndBonusNumberMatch = 0;
    private int countOf6NumbersMatch = 0;
    private int lottoCount = 0;

    private Long totalWinnings;
    private Float rateOfReturn;

    public void setNumberMatchCounts(int numberMatchCount, boolean isBonusNumberMatch) {
        if (numberMatchCount == 3) {
            countOf3NumbersMatch++;
        }
        if (numberMatchCount == 4) {
            countOf4NumbersMatch++;
        }
        if (numberMatchCount == 5) {
            countOf5NumbersMatch++;
        }
        if (numberMatchCount == 5 && isBonusNumberMatch) {
            countOf5NumbersAndBonusNumberMatch++;
        }
        if (numberMatchCount == 6) {
            countOf6NumbersMatch++;
        }
        lottoCount++;
    }

    public Long calculateTotalWinnings() {
        totalWinnings = (countOf6NumbersMatch * LOTTO_6_NUMBERS_MATCH.getWinnings())
                + (countOf5NumbersAndBonusNumberMatch * LOTTO_5_NUMBERS_AND_BONUS_NUMBER_MATCH.getWinnings())
                + (countOf5NumbersMatch * LOTTO_5_NUMBERS_MATCH.getWinnings())
                + (countOf4NumbersMatch * LOTTO_4_NUMBERS_MATCH.getWinnings())
                + (countOf3NumbersMatch * LOTTO_3_NUMBERS_MATCH.getWinnings());

        return totalWinnings;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getCountOf3NumbersMatch() {
        return countOf3NumbersMatch;
    }

    public int getCountOf4NumbersMatch() {
        return countOf4NumbersMatch;
    }

    public int getCountOf5NumbersMatch() {
        return countOf5NumbersMatch;
    }

    public int getCountOf5NumbersAndBonusNumberMatch() {
        return countOf5NumbersAndBonusNumberMatch;
    }

    public int getCountOf6NumbersMatch() {
        return countOf6NumbersMatch;
    }

    public Long getTotalWinnings() {
        return totalWinnings;
    }
    public Float getRateOfReturn() {
        return rateOfReturn;
    }

    public void setRateOfReturn(float rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }
}
