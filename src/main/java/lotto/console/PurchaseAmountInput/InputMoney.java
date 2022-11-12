package lotto.console.PurchaseAmountInput;

import camp.nextstep.edu.missionutils.Console;

public class InputMoney {

    public int getAndVerifyMoney() {
        int purchaseMoney = getPurchaseMoney();
        verifyCommonMultipleOf1000(purchaseMoney);

        return purchaseMoney;
    }

    private int getPurchaseMoney() {
        return Integer.parseInt(Console.readLine());
    }

    private void verifyCommonMultipleOf1000(int purchaseNumber) {
        if (purchaseNumber % 1000 != 0) {
            throw new RuntimeException("[ERROR] 1000원 단위로 입력해야 합니다.");
        }
    }
}
