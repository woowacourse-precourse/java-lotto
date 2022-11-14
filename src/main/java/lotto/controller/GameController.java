package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.TotalLottoResult;
import lotto.service.GameService;
import lotto.view.GameView;

import java.util.List;

public class GameController {
    private static final GameView gameView = GameView.getInstance();
    private static final GameService gameService = GameService.getInstance();

    private GameController() { }

    public static void runGame() {
        int purchaseAmount = payForLotto();
        List<Lotto> purchasedLottos = purchaseLotto(purchaseAmount);
        drawWinningLotto();
        summarizeResult(purchasedLottos);
    }

    public static void informExitByError(Exception exception) {
        gameView.ShowExitByErrorMessage(exception);
    }

    private static int payForLotto() {
        int lottoPayment = gameView.askPayment();
        gameService.initializePaymentCalculator(lottoPayment);
        return gameService.calculatePurchaseAmount();
    }

    private static List<Lotto> purchaseLotto(int purchaseAmount) {
        gameView.showPurchaseAmount(purchaseAmount);
        List<Lotto> purchasedLottos = gameService.sellLottosByAmount(purchaseAmount);
        gameView.showPurchasedLottos(purchasedLottos);
        return purchasedLottos;
    }

    private static void drawWinningLotto() {
        List<Integer> drawnNumbers = gameView.askLottoDrawNumbers();
        int drawnBonusNumber = gameView.askLottoDrawBonusNumber();
        gameService.drawLotto(drawnNumbers, drawnBonusNumber);
    }

    private static void summarizeResult(List<Lotto> purchasedLottos) {
        TotalLottoResult result = gameService.checkTotalLottoResult(purchasedLottos);
        gameView.showTotalLottoResult(result);
        double earningRatio = gameService.calculateEarningRatio(result.addUpTotalPrizeAmount());
        gameView.showEarningRatio(earningRatio);
    }
}
