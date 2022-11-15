package lotto.domain;

import java.util.List;

import static lotto.constant.LottoConstant.*;
import static lotto.constant.MessageConstant.YIELD_MESSAGE;

public class CalculateYield {

    int pay = 0;
    int prizeMoney = 0;

    public CalculateYield(int price) {
        this.pay = price;
    }

    public void calculatePrizeMoney(List<Integer> winNumber) {
        if (winNumber.get(3) != 0) {
            prizeMoney = winNumber.get(3) * FIFTH_MONEY.getValue();
        }
        if (winNumber.get(4) != 0) {
            prizeMoney = winNumber.get(4) * FOURTH_MONEY.getValue();
        }
        if (winNumber.get(5) != 0) {
            prizeMoney = winNumber.get(5) * THIRD_MONEY.getValue();
        }
        if (winNumber.get(7) != 0) {
            prizeMoney = winNumber.get(7) * SECOND_MONEY.getValue();
        }
        if (winNumber.get(6) != 0) {
            prizeMoney = winNumber.get(6) * FIRST_MONEY.getValue();
        }
    }

    public void printPrizeMoney() {
        System.out.println(String.format(YIELD_MESSAGE.getMessage(), (double)prizeMoney/pay*PERCENTAGE.getValue()));
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
