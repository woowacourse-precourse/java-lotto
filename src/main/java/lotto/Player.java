package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private final Exception exception = new Exception();

    public String getLottoPurchaseInput() {
        String input = Console.readLine();
        exception.checkPurchaseInput(input);

        return input;
    }
}

