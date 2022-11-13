package lotto.application.input.purchasemoney;

import lotto.application.util.inputagent.InputAgent;

public class PurchaseMoneyInputImpl implements PurchaseMoneyInput {

    private final InputAgent inputAgent;

    public PurchaseMoneyInputImpl(InputAgent inputAgent) {
        this.inputAgent = inputAgent;
    }

    @Override
    public int inputPurchaseMoney() {
        System.out.println("구매금액을 입력해 주세요.");

        int inputValue = 0;
        try {
            inputValue = inputAgent.inputUserPurchaseMoney();
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(exception.getMessage());
        }
        System.out.printf("\n%d개를 구매했습니다.\n", inputValue / 1000);

        return inputValue;
    }
}
