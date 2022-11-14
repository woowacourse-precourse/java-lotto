package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private static final int LOTTO_PRICE = 1000;
    private final Exception exception = new Exception();
    private final LottoBot lottoBot;

    public Player(LottoBot lottoBot) {
        this.lottoBot = lottoBot;
    }

    public int getLottoCountPurchased() {
        int money = getMoneyPurchased();
        lottoBot.saveInitialMoney(money);
        return money / LOTTO_PRICE;
    }

    private int getMoneyPurchased() {
        String money = Console.readLine();
        exception.checkPurchaseInput(money);
        return Integer.parseInt(money);
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

