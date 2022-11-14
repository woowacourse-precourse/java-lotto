package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public InputView() {}

    public String inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        String input = readLine();
        return input;
    }

}