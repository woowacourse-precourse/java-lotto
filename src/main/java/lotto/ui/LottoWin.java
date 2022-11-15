package lotto.ui;

public enum LottoWin {
    FIFTH_PLACE("3개 일치", "5,000원", 5000),
    FOURTH_PLACE("4개 일치", "50,000원", 50000),
    THIRD_PLACE("5개 일치", "1,500,000원", 1500000),
    SECOND_PLACE("5개 일치, 보너스 볼 일치", "30,000,000원", 3000000),
    FIRST_PLACE("6개 일치", "2,000,000,000원", 2000000000);


    private final String winningCriteria;
    private final String winnings;
    private final Integer money;

    LottoWin(String winningCriteria, String winnings, Integer money) {
        this.winningCriteria = winningCriteria;
        this.winnings = winnings;
        this.money = money;
    }

    public void print(int numberWins) {
        String winningDetail = String.format(
            "%s (%s) - %d개", this.winningCriteria, this.winnings, numberWins
        );
        System.out.println(winningDetail);
    }

    public int getWinningAmount(int count) {
        return this.money * count;
    }

    public static LottoWin getWinPlace(long count, boolean hasBonusNumber) {
        if (count == 6) {
            return LottoWin.FIRST_PLACE;
        }

        if (count == 5 && hasBonusNumber) {
            return LottoWin.SECOND_PLACE;
        }

        if (count == 5) {
            return LottoWin.THIRD_PLACE;
        }

        if (count == 4) {
            return LottoWin.FOURTH_PLACE;
        }

        return LottoWin.FIFTH_PLACE;
    }
}
