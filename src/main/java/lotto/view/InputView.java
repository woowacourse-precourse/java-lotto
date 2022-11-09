package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";

    public static int inputMoney() {
        System.out.println(INPUT_MONEY);
        return Integer.parseInt(Console.readLine());
    }
}
