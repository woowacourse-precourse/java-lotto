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
        money = eraseAllBlank(money);
        validation.checkPurchaseInput(money);
        return Integer.parseInt(money);
    }

    public void selectWinningNumbers() {
        String numbers = Console.readLine();
        numbers = eraseAllBlank(numbers);
        validation.checkWinningNumberInput(numbers);

        String[] winningNumbers = numbers.split(",");
        lottoBot.saveWinningNumbers(winningNumbers);
    }

    public void selectBonusNumber() {
        String number = Console.readLine();
        number = eraseAllBlank(number);
        validation.checkBonusNumberInput(number);

        lottoBot.saveBonusNumber(number);
    }

    private String eraseAllBlank(String str) {
        return str.replace(" ", "");
    }
}

