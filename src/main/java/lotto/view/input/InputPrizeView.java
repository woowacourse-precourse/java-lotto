package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputPrizeView {
    private static final String INPUT_PRIZE_NUMBER = "당첨 번호를 입력해 주세요.";

    private final String input;

    public InputPrizeView() {
        System.out.println("\n" + INPUT_PRIZE_NUMBER);
        input = Console.readLine();
    }

    public String getInput() {
        return input;
    }
}
