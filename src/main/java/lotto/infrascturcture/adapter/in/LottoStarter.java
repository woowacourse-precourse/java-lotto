package lotto.infrascturcture.adapter.in;

import lotto.infrascturcture.adapter.output.calculator.YieldCalculator;
import lotto.application.in.client.Client;
import lotto.application.output.lotterymatch.LottoHost;
import lotto.domain.Lotto;

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
        int bonusWinningNumber = lotto.inputWinningBonusNumber(winningLotto);

        List<List<Integer>> matchResult = lottoHost.matchNotContainBonusNumber(
                generatedLottoNumber, winningLotto, bonusWinningNumber);

        Map<String, Integer> statistic = yieldCalculator.extractStatistic(matchResult);
        yieldCalculator.showStatistic(statistic);
        yieldCalculator.getYield(statistic, purchaseNumber);
    }
}
