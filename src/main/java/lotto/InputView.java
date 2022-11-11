package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public int inputMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        int purchasingAmount = Integer.parseInt(Console.readLine());

        return purchasingAmount;
    }
}
