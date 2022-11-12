package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {
    public static int getPurchaseAmount() {
        String amount = Console.readLine();
        InputValidator.validateToParseInt(amount);
        return Integer.parseInt(amount);
    }
}
