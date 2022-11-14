package lotto;

import lotto.io.Inputter;
import lotto.io.MessagePrinter;

import java.util.List;

public class LottoGameSimulator {
    private LottoGameResult lottoGameResult;
    private List<Lotto> purchasedLottos;
    private WinningNumbers winningNumbers;
    private int paidMoney;
    public LottoGameSimulator() {
    }

    public void run() {
        getInputOfMoney();
        printGeneratedLotto();
        getInputOfWinningNumbers();
        getInputOfBonusNumber();
        generateResult();
        printResult();
    }

    public void getInputOfMoney() {
        MessagePrinter.printMoneyInputRequest();
        String moneyInput = Inputter.readLine();
        MoneyValidator.validate(moneyInput);
        paidMoney = Integer.parseInt(moneyInput);
    }

    public void printGeneratedLotto() {
        int lottoQuantity = paidMoney / 1000;
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
        registerBonusNumberToWinningNumbers(bonusNumberInput);
    }

    public void registerBonusNumberToWinningNumbers(String bonusNumberInput) {
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        winningNumbers.registerBonusNumber(bonusNumber);
    }

    public void generateResult() {
        LottoGameResultGenerator lottoGameResultGenerator = new LottoGameResultGenerator();
        lottoGameResult = lottoGameResultGenerator
                .generateLottoGameResult(purchasedLottos, winningNumbers, paidMoney);
    }

    public void printResult() {
        MessagePrinter.printWinningDetails(lottoGameResult.getWinningDetails());
        MessagePrinter.printEarningRate(lottoGameResult.getEarningRate());
    }
}
