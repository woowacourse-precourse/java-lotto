package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.chart.ErrorPrint;
import lotto.domain.chart.NumberChart;

public class InputMoney {

    public int getAndVerifyMoney() {
        String purchaseMoney = getPurchaseMoney();
        verifyItIsNumber(purchaseMoney);
        int moneyNumber = Integer.parseInt(purchaseMoney);
        verifyCommonMultipleOf1000(moneyNumber);
        verifyEmptyMoney(moneyNumber);

        return moneyNumber;
    }

    private String getPurchaseMoney() {
        return Console.readLine();
    }

    private void verifyCommonMultipleOf1000(int purchaseNumber) {
        if (purchaseNumber % NumberChart.LOTTO_MONEY.getValue() != 0) {
            throw new IllegalArgumentException(ErrorPrint.ERROR_1000.getValue());
        }
    }

    private void verifyEmptyMoney(int purchaseNumber) {
        if (purchaseNumber == NumberChart.EMPTY_MONEY.getValue()) {
            throw new IllegalArgumentException(ErrorPrint.ERROR_MONEY_0.getValue());
        }
    }

    private void verifyItIsNumber(String money) {
        String regex = "[0-9]+";
        if (!(money.matches(regex))) {
            throw new IllegalArgumentException(ErrorPrint.ERROR_ONLY_NUMBER.getValue());
        }
    }
}
