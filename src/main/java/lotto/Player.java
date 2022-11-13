package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private final Exception exception = new Exception();

    public String getLottoPurchaseInput() {
        String input = Console.readLine();
        exception.checkPurchaseInput(input);

        return input;
    }

    public String getWinningNumberInput() {
        String input = Console.readLine();
        exception.checkWinningNumberInput(input);

        return input;
    }

    public String getBonusNumberInput() {
        String input = Console.readLine();
        exception.checkBonusNumberInput(input);

        return input;
    }
}

