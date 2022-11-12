package lotto.Model;

import lotto.Cash;
import lotto.Prize;

public class CalculatorModel {
    private final static int MIN_UNIT = 1000;

    public Prize givePrize(int matchNumber, boolean bonus) {
        if (matchNumber == 6) {
            return Prize.FIRST;
        } else if (matchNumber == 5) {
            if (bonus) {
                return Prize.SECOND;
            }
            return Prize.THIRD;
        } else if (matchNumber == 4) {
            return Prize.FOURTH;
        } else if (matchNumber == 3) {
            return Prize.FIFTH;
        }

        return Prize.LAST;
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
