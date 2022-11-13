package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private static final int LOTTO_PRICE = 1000;
    private final Exception exception = new Exception();

    public int getLottoCountPurchased() {
        String input = getMoneyPurchased();
        return Integer.parseInt(input) / LOTTO_PRICE;
    }

    private String getMoneyPurchased() {
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

