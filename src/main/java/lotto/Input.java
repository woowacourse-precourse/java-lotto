package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int purchaseAmount() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
