package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private static final int LOTTO_PRICE = 1000;
    private final Exception exception = new Exception();
    private final LottoBot lottoBot = new LottoBot();

    public int getLottoCountPurchased() {
        String input = getMoneyPurchased();
        return Integer.parseInt(input) / LOTTO_PRICE;
    }

    private String getMoneyPurchased() {
        String input = Console.readLine();
        exception.checkPurchaseInput(input);
        return input;
    }

    public void selectWinningNumbers() {
        String input = Console.readLine();
        exception.checkWinningNumberInput(input);

        String[] winningNumbers = input.split(",");
        lottoBot.saveWinningNumbers(winningNumbers);
    }

    public void selectBonusNumber() {
        String input = Console.readLine();
        exception.checkBonusNumberInput(input);

        lottoBot.saveBonusNumber(input);
    }
}

