package lotto.view;

import java.util.List;
import lotto.core.Lotto;
import lotto.core.LotteryPublisher;
import lotto.util.Logger;
import lotto.core.LottoRank;
import lotto.core.LottoResult;
import lotto.core.LottoWinningDiscriminator;

public class MainView {
    private final InputView inputView;
    private final LotteryPublisher publisher;

    public MainView(InputView inputView, LotteryPublisher publisher) {
        this.inputView = inputView;
        this.publisher = publisher;
    }

    public void start() {
        try {
            int purchaseAmount = inputView.inputPurchaseAmount();
            List<Lotto> purchasedLotto = purchaseLotto(purchaseAmount);

            List<Integer> winningNumber = inputView.inputWinningNumber();
            int bonusNumber = inputView.inputBonusNumber(winningNumber);
            List<LottoRank> winningResult = discriminatePurchasedLotto(purchasedLotto, winningNumber, bonusNumber);

            new ResultView(new LottoResult(winningResult)).printWinningStats();
        } catch (IllegalArgumentException e) {
            Logger.printError(e.getMessage());
        }
    }

    private List<Lotto> purchaseLotto(int purchaseAmount) {
        List<Lotto> purchasedLotto = publisher.publishByPurchaseAmount(purchaseAmount);
        printPurchasedLotto(purchasedLotto);
        return purchasedLotto;
    }

    private List<LottoRank> discriminatePurchasedLotto(
            List<Lotto> purchasedLotto,
            List<Integer> winningNumber,
            int bonusNumber
    ) {
        return new LottoWinningDiscriminator(winningNumber, bonusNumber)
                .discriminate(purchasedLotto);
    }

    private void printPurchasedLotto(List<Lotto> purchasedLotto) {
        purchasedLotto.stream().forEach(this::printLottoNumber);
    }

    private void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }
}
