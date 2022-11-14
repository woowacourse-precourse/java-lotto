package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Player {
    private final Validation validation = new Validation();
    private final LottoBot lottoBot;

    public Player(LottoBot lottoBot) {
        this.lottoBot = lottoBot;
    }

    public int getLottoCountPurchased() {
        int money = getMoneyPurchased();
        lottoBot.saveInitialMoney(money);
        return money / Lotto.LOTTO_PRICE;
    }

    private int getMoneyPurchased() {
        String money = Console.readLine();
        validation.checkPurchaseInput(money);
        return Integer.parseInt(money);
    }

    public void selectWinningNumbers() {
        String input = Console.readLine();
        validation.checkWinningNumberInput(input);

        String[] winningNumbers = input.split(",");
        lottoBot.saveWinningNumbers(winningNumbers);
    }

    public void selectBonusNumber() {
        String input = Console.readLine();
        validation.checkBonusNumberInput(input);

        lottoBot.saveBonusNumber(input);
    }
}

