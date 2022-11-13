package lotto.console.PurchaseAmountInput;

import camp.nextstep.edu.missionutils.Console;
import lotto.console.Output;
import lotto.domain.chart.NumberChart;

public class InputMoney {

    Output output = new Output();

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
            throw new IllegalArgumentException(" 1000원 단위로 입력해야 합니다.");
        }
    }

    private void verifyEmptyMoney(int purchaseNumber) {
        if (purchaseNumber == NumberChart.EMPTY_MONEY.getValue()) {
            throw new IllegalArgumentException(" 돈을 내세요");
        }
    }

    private void verifyItIsNumber(String money) {
        String regex = "[0-9]+";
        if (!(money.matches(regex))) {
            throw new IllegalArgumentException(" 숫자입력");
        }
    }
}
