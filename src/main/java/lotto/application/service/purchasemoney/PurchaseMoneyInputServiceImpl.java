package lotto.application.service.purchasemoney;

import lotto.application.service.inputagent.InputAgent;

public class PurchaseMoneyInputServiceImpl implements PurchaseMoneyInputService {


    private final InputAgent inputAgent;

    public PurchaseMoneyInputServiceImpl(InputAgent inputAgent) {
        this.inputAgent = inputAgent;
    }

    @Override
    public int inputPurchaseMoney() {
        System.out.println("구매금액을 입력해 주세요.");

        int inputValue = 0;
        try {
            inputValue = inputAgent.inputUserPurchaseMoney();
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException();
        }
        System.out.printf("\n%d개를 구매했습니다.\n", inputValue / 1000);

        return inputValue / 1000;
    }
}
