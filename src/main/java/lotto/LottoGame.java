package lotto;

import util.Converter;
import util.Input;
import util.Output;
import util.InputValidator;

import java.util.List;

public class LottoGame {
    public void run() {
        Money money = inputUserMoney();
        Lotteries lotteries = buyLotteriesWithMoney(money);
    }

    private Money inputUserMoney() {
        String purchaseAmount = Input.purchaseAmount();

        InputValidator.validateDigits(purchaseAmount);
        int money = Integer.parseInt(purchaseAmount);
        InputValidator.validateMinimumMoney(money);

        return new Money(money);
    }

    private Lotteries buyLotteriesWithMoney(Money money) {
        int lottoCount = money.calculateLottoCount();
        Output.printCountOfLotteries(lottoCount);

        List<Lotto> lottoList = LottoFactory.newLottoList(lottoCount);
        Lotteries lotteries = new Lotteries(lottoList);
        Output.printAllLotteries(lotteries);

        return lotteries;
    }

    private static List<Integer> inputWinningNumbers() {
        String inputWinningNumbers = Input.getWinningNumbers();
        List<Integer> winningNumbers = Converter.splitFromString(inputWinningNumbers);

        InputValidator.validateSplitSize(winningNumbers);
        InputValidator.validateWinningNumbersRange(winningNumbers);

        return winningNumbers;
    }

    private static int inputBonusNumber() {
        String inputBonusNumber = Input.getBonusNumber();
        InputValidator.validateDigits(inputBonusNumber);

        int bonusNumber = Integer.parseInt(inputBonusNumber);
        InputValidator.validateBonusNumberRange(bonusNumber);

        return bonusNumber;
    }
}
