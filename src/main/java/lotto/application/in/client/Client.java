package lotto.application.in.client;

import lotto.application.service.agent.InputAgent;

public class Client {

    public int getPurchaseMoney() {
        System.out.println("구매금액을 입력해 주세요.");
        InputAgent inputAgent = new InputAgent();
        int inputValue = 0;
        try {
            inputValue = inputAgent.inputUserMoney();
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 입력 오류 입니다. 에러 로그를 확인해주세요.");
        }
        System.out.printf("\n%d개를 구매했습니다.\n", inputValue / 1000);
        return inputValue / 1000;
    }
}
