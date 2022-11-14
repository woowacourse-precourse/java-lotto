package lotto;

import lotto.controller.GameManager;
import lotto.domain.Buyer;
import lotto.domain.History;
import lotto.domain.WinningNumber;
import lotto.viewer.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseNumber = GameManager.determinePurchaseNumber();
            Buyer buyer = GameManager.buyLottos(purchaseNumber);
            WinningNumber winningNumber = GameManager.getWinningNumber();

            History history = buyer.play(winningNumber);
            OutputView.showHistory(history);
            OutputView.showProfitRate(history);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
