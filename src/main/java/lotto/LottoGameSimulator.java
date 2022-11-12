package lotto;

import lotto.io.Inputter;
import lotto.io.MessagePrinter;

public class LottoGameSimulator {
    private Money userMoney;
    public LottoGameSimulator() {
    }

    public void run() {
        getInputOfMoney();
        printGeneratedLotto();
        getInputOfWinningNumbers();
        getInputOfBonusNumber();
        printResult();
    }

    public void getInputOfMoney() {
        MessagePrinter.printMoneyInputRequest();
        String moneyInput = Inputter.readLine();
        MoneyValidator.validate(moneyInput);
        int money = Integer.parseInt(moneyInput);
        userMoney = new Money(money);
    }

    public void printGeneratedLotto() {

    }

    public void getInputOfWinningNumbers() {

    }

    public void getInputOfBonusNumber() {

    }

    public void printResult() {

    }
}
