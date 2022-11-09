package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String INPUT_MONEY = "구입금액을 입력해 주세요.";

    public static String inputMoney() {
        System.out.println(INPUT_MONEY);
        return Console.readLine();
    }
}
