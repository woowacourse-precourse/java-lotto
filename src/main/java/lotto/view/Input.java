package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        System.out.println();
        return Integer.parseInt(inputMoney);
    }
}
