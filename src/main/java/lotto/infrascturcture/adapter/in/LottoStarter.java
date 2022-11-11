package lotto.infrascturcture.adapter.in;

import lotto.infrascturcture.adapter.output.calculator.YieldCalculator;
import lotto.application.in.client.Client;
import lotto.application.output.lotterymatch.LottoHost;
import lotto.domain.Lotto;

import java.util.List;

public class LottoStarter {

    public void start() {
        Client client = new Client();
        int purchaseNumber = client.getPurchaseMoney();

        List<List<Integer>> generatedLottoNumber = Lotto.generateLottoNumber(purchaseNumber);
        Lotto.getGeneratedLottoNumber(generatedLottoNumber);
        List<Integer> winningLotto = Lotto.inputWinningLottoNumbers();
        Lotto lotto = new Lotto(winningLotto);
        int bonusWinningNumber = lotto.inputWinningBonusNumber(winningLotto);

        LottoHost lottoHost = new LottoHost();
        List<Integer> matchResultNotContainBonusNumber =
                lottoHost.matchNotContainBonusNumber(generatedLottoNumber, winningLotto, bonusWinningNumber);
        List<Integer> matchResultContainBonusNumber =
                lottoHost.matchContainBonusNumber(generatedLottoNumber, winningLotto, bonusWinningNumber);

        YieldCalculator yieldCalculator = new YieldCalculator();
        yieldCalculator.getYield(yieldCalculator
                .getStatistics(matchResultNotContainBonusNumber, matchResultContainBonusNumber), purchaseNumber);
    }
}
