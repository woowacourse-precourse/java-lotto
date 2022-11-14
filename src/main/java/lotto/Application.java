package lotto;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.ui.NumbersReceiver;
import lotto.ui.OutputPrinter;

import java.util.List;
import java.util.Map;

public class Application {
    static NumbersReceiver numbersReceiver = new NumbersReceiver();
    static Buyer buyer = new Buyer();
    static OutputPrinter outputPrinter = new OutputPrinter();
    public static void main(String[] args) {
        try {
            long startMoney = numbersReceiver.insertMoney();

            List<List<Integer>> purchasedLottos = buyer.receiveLottos(startMoney);
            outputPrinter.printPurchasedNumbers(purchasedLottos);

            List<Integer> basicWinningNumbers = numbersReceiver.setBasicNumbers();
            Lotto lotto = new Lotto(basicWinningNumbers);
            int bonusNumber = numbersReceiver.setBonusNumber();

            Map<WinningNumbers, Long> winningCaseStatistics = lotto.countWinningCase(bonusNumber, purchasedLottos);
            double rawRewardRate = lotto.calculateRewardRate(bonusNumber, purchasedLottos, startMoney);
            outputPrinter.printFinalResult(winningCaseStatistics, rawRewardRate);

        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
