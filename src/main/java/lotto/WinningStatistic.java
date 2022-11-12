package lotto;

public enum WinningStatistic {
    RANK_ONE(6, false),
    RANK_TWO(5, true),
    RANK_THREE(5, false),
    RANK_FOUR(4, false),
    RANK_FIVE(3, false),
    RANK_ZERO(0, false);
    private final int numOfCorrectLottoNum;
    private final boolean bonusLottoNumCorrect;
    private final int ranking;
    private final int cashPrize;

    public static WinningStatistic getInstance(int numOfCorrectLottoNum,
        boolean bonusLottoNumCorrect) {
        switch (numOfCorrectLottoNum) {
            case 3:
                return RANK_FIVE;
            case 4:
                return RANK_FOUR;
            case 5:
                if (!bonusLottoNumCorrect) {
                    return RANK_THREE;
                }
                return RANK_TWO;
            case 6:
                return RANK_ONE;
        }
        return RANK_ZERO;
    }

    WinningStatistic(int numOfCorrectLottoNum, boolean bonusLottoNumCorrect) {
        this.numOfCorrectLottoNum = numOfCorrectLottoNum;
        this.bonusLottoNumCorrect = bonusLottoNumCorrect;
        validate();
        this.ranking = calculateRanking();
        this.cashPrize = calculateCashPrize();
    }

    void validate() {
        if (numOfCorrectLottoNum < 1 || numOfCorrectLottoNum > 6) {
            throw new IllegalArgumentException();
        }
    }

    int calculateCashPrize() {
        switch (numOfCorrectLottoNum) {
            case 3:
                return 5000;
            case 4:
                return 50000;
            case 5:
                if (!bonusLottoNumCorrect) {
                    return 1500000;
                }
                return 30000000;
            case 6:
                return 2000000000;
        }
        return 0;
    }

    int calculateRanking() {
        switch (numOfCorrectLottoNum) {
            case 3:
                return 5;
            case 4:
                return 4;
            case 5:
                if (!bonusLottoNumCorrect) {
                    return 3;
                }
                return 2;
            case 6:
                return 1;
        }
        return 0;
    }


    public int getNumOfCorrectLottoNum() {
        return numOfCorrectLottoNum;
    }

    public int getRanking() {
        return ranking;
    }

    public int getCashPrize() {
        return cashPrize;
    }
}
