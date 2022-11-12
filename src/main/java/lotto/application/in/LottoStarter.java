package lotto.application.in;

import lotto.application.service.yield.YieldCalculator;
import lotto.domain.client.Client;
import lotto.application.service.lottohost.LottoHost;
import lotto.domain.lotto.Lotto;

import java.util.List;
import java.util.Map;

public class LottoStarter {

    private final LottoHost lottoHost = new LottoHost();
    private final YieldCalculator yieldCalculator = new YieldCalculator();

    public void start() {
        int purchaseNumber = Client.getPurchaseMoney();

        List<List<Integer>> generatedLottoNumber = Lotto.generateLottoNumber(purchaseNumber);
        Lotto.getGeneratedLottoNumber(generatedLottoNumber);
        List<Integer> winningLotto = Lotto.inputWinningLottoNumbers();
        Lotto lotto = new Lotto(winningLotto);
        int bonusWinningNumber = lotto.inputWinningLottoBonusNumber(winningLotto);

        List<List<Integer>> matchResult = lottoHost.matchWinningLotto(
                generatedLottoNumber, winningLotto, bonusWinningNumber);

        Map<String, Integer> statistic = yieldCalculator.extractStatistic(matchResult);
        yieldCalculator.showStatistic(statistic);
        yieldCalculator.showYield(statistic, purchaseNumber);
    }
}
