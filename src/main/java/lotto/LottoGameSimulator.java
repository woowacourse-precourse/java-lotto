package lotto;

import lotto.io.Inputter;
import lotto.io.MessagePrinter;

import java.util.List;

public class LottoGameSimulator {
    private List<Lotto> purchasedLottos;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;
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
        int lottoQuantity = userMoney.getMoney() / 1000;
        purchasedLottos = LottoGenerator.generateLottos(lottoQuantity);
        MessagePrinter.printGeneratedLottoQuantity(lottoQuantity);
        MessagePrinter.printGeneratedLottoNumbers(purchasedLottos);
    }

    public void getInputOfWinningNumbers() {
        MessagePrinter.printWinningNumbersInputRequest();
        String winningNumbersInput = Inputter.readLine();
        WinningNumbersValidator.validate(winningNumbersInput);
        winningNumbers = WinningNumbersGenerator.generateWinningNumbers(winningNumbersInput);
    }

    public void getInputOfBonusNumber() {
        MessagePrinter.printBonusNumberInputRequest();
        String bonusNumberInput = Inputter.readLine();
        BonusNumberValidator.validate(bonusNumberInput, winningNumbers);
    }

    public void printResult() {

    }
}
