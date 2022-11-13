package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private Input() {
    }

    public static int amount() {
        String money = Console.readLine();
        return Integer.parseInt(money);
    }
}
