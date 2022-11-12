package lotto;

import lotto.io.Inputter;
import lotto.io.MessagePrinter;

public class LottoGameSimulator {
    private Money money;
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
        MoneyValidator.validateMoney(moneyInput);
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
