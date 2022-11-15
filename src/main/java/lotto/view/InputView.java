package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    public static InputView getInstance() {
        return new InputView();
    }

    public String input() {
        return Console.readLine();
    }
}
