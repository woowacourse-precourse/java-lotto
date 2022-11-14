package lotto;

import lotto.io.Inputter;
import lotto.io.MessagePrinter;

import java.util.List;

public class LottoGameSimulator {
    private LottoGameResult lottoGameResult;
    private List<Lotto> Lottos;
    private WinningNumbers winningNumbers;
    private int paidMoney;
    public LottoGameSimulator() {
    }

    public void run() {
        try {
            buyLotto();
            printLottos();
            getInputOfWinningNumbers();
            getInputOfBonusNumber();
            generateResult();
            printResult();
        } catch (IllegalArgumentException exception) {
            MessagePrinter.printErrorMessage(exception);
        }
    }

    public void buyLotto() {
        String moneyInput = getInputOfMoney();
        validateMoney(moneyInput);
        paidMoney = Integer.parseInt(moneyInput);
        generateLottos();
    }

    public String getInputOfMoney() {
        MessagePrinter.printMoneyInputRequest();
        String moneyInput = Inputter.readLine();
        return moneyInput;
    }

    public void validateMoney(String moneyInput) {
        MoneyValidator.validate(moneyInput);
    }

    public void generateLottos() {
        Lottos = LottoGenerator.generateLottos(paidMoney);
    }

    public void printLottos() {
        MessagePrinter.printGeneratedLottoQuantity(paidMoney);
        MessagePrinter.printGeneratedLottoNumbers(Lottos);
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
                .generateLottoGameResult(Lottos, winningNumbers, paidMoney);
    }

    public void printResult() {
        MessagePrinter.printWinningDetails(lottoGameResult.getWinningDetails());
        MessagePrinter.printEarningRate(lottoGameResult.getEarningRate());
    }
}
