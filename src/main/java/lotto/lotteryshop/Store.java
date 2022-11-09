package lotto.lotteryshop;

import lotto.input.InputAgent;

public class Store {

    public int getPurchaseNumberOfLotto() {
        System.out.println("구매금액을 입력해 주세요.");
        InputAgent inputAgent = new InputAgent();
        int inputValue = inputAgent.inputUserMoney();
        System.out.printf("%d개를 구매했습니다.", inputValue / 1000);
        return inputValue;
    }
}
