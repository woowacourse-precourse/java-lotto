package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private String input;

    public String number() {
        input = Console.readLine();
        return input;
    }
}
