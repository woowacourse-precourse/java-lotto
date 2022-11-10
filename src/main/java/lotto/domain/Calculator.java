package lotto.domain;

import lotto.domain.Prize;

public class Calculator {
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

    public int countPublicationLotto(int investmentCash) {
        return investmentCash / 1000;
    }
}
