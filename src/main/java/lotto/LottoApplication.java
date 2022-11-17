package lotto;

import lotto.domain.lotto.LottoDraw;
import lotto.domain.lotto.Lottos;
import lotto.domain.winningresult.LottoStatistics;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.ui.dto.LottoPurchasedAmount;

public class LottoApplication {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoApplication(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        LottoPurchasedAmount lottoPurchasedAmount = inputView.getLottoPurchasedAmount();
        Lottos lottos = generateLottos(lottoPurchasedAmount.getLottoPurchasedAmount());

        resultView.printDrawnLottos(lottos);
        LottoDraw lottoDraw = inputView.getLottoDraw();
        LottoStatistics lottoStatistics = LottoStatistics.of(lottos, lottoDraw);

        resultView.printStatistics(lottoStatistics);
    }

    private Lottos generateLottos(int purchasedAmount) {
        return Lottos.from(purchasedAmount);
    }
}
