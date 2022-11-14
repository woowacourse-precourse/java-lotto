package lotto;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            int purchaseAmount = InputView.askPurchaseAmount();
            Quantity quantity = new Quantity(purchaseAmount);
            LottosGenerator lottosGenerator = new LottosGenerator();
            List<Lotto> lottos = lottosGenerator.createLottos(quantity);

            OutputView.printLottoQuantity(quantity);
            OutputView.printLottos(lottos);

            List<Integer> playerNumbers = InputView.askNumbers();
            int bonusNumber = InputView.askBonusNumber(playerNumbers);

            Referee referee = new Referee();
            List<WinningStat> winningStats = referee.compare(lottos, playerNumbers, bonusNumber);
            Profit profit = new Profit(winningStats);

            OutputView.printStatistics(winningStats);
            OutputView.printProfit(profit, quantity);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
