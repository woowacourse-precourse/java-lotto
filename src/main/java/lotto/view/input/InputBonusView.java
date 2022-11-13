package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputBonusView {
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private final String input;

    public InputBonusView() {
        System.out.println("\n" + INPUT_BONUS_NUMBER);
        input = Console.readLine();
    }

    public String getInput() {
        return input;
    }
}
