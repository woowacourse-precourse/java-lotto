package lotto.view;

import camp.nextstep.edu.missionutils.Console;


public class InputView {

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        return Integer.parseInt(money);
    }
}
