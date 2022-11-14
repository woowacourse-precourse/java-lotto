package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WON_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public InputView() {}

    public String inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return readLine();
    }

    public String inputWonNumber() {
        System.out.println();
        System.out.println(INPUT_WON_NUMBER_MESSAGE);
        return readLine();
    }

    public String inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return readLine();
    }

}