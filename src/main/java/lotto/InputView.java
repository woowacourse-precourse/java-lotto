package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_AMOUNT_MESSAGE = "숫자를 입력해주세요 : ";

    public String enterAmount() {
        System.out.print(INPUT_AMOUNT_MESSAGE);
        return Console.readLine();
    }
}
