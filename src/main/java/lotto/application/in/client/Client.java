package lotto.application.in.client;

import lotto.application.service.agent.InputAgent;

public class Client {

    public static int getPurchaseMoney() {
        System.out.println("구매금액을 입력해 주세요.");
        InputAgent inputAgent = new InputAgent();
        int inputValue = 0;
        try {
            inputValue = inputAgent.inputUserMoney();
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException();
        }
        System.out.printf("\n%d개를 구매했습니다.\n", inputValue / 1000);
        return inputValue / 1000;
    }
}
