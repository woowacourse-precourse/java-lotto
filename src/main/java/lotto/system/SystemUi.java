package lotto.system;

import camp.nextstep.edu.missionutils.Console;

public class SystemUi {

    private static final String START_MESSAGE = "구입금액을 입력해 주세요.";

    public String getPurchaseAmount() {
        System.out.println(START_MESSAGE);
        return Console.readLine();
    }
}
