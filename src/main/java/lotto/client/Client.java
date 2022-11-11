package lotto.client;

import lotto.input.InputAgent;

public class Client {

    public int getPurchaseMoney() {
        System.out.println("구매금액을 입력해 주세요.");
        InputAgent inputAgent = new InputAgent();
        int inputValue = inputAgent.inputUserMoney();
        System.out.printf("\n%d개를 구매했습니다.\n", inputValue / 1000);
        return inputValue / 1000;
    }
}
