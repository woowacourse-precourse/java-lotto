package lotto.Model;

import lotto.Cash;
import lotto.Rank;

public class CalculatorModel {
    private final static int MIN_UNIT = 1000;

    public Rank getRank(int matchNumber, boolean bonus) {
        if (matchNumber == 6) {
            return Rank.FIRST;
        } else if (matchNumber == 5) {
            if (bonus) {
                return Rank.SECOND;
            }
            return Rank.THIRD;
        } else if (matchNumber == 4) {
            return Rank.FOURTH;
        } else if (matchNumber == 3) {
            return Rank.FIFTH;
        }

        return Rank.LAST;
    }

    public double getProfit(int totalPrize, int investmentCash) {
        double profit = ((double) totalPrize / investmentCash) * 100 * 10;
        profit = Math.round(profit);

        return profit / 10;
    }

    public int countLottoNumber(Cash cash) {
        return cash.getCash() / MIN_UNIT;
    }
}
