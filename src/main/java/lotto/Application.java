package lotto;

import lotto.calculator.YieldCalculator;
import lotto.client.Client;
import lotto.lotteryhost.LottoHost;
import lotto.lotteryshop.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Client client = new Client();
        int purchaseNumber = client.getPurchaseMoney();

        List<Integer> winningLotto = new ArrayList<>();
        Lotto lotto = new Lotto(winningLotto);
        List<List<Integer>> generatedLottoNumber = lotto.generateLottoNumber(purchaseNumber);
        lotto.getGeneratedLottoNumber(generatedLottoNumber);
        winningLotto = lotto.publishWinningLottoNumbers();
        lotto.publishWinningBonusNumber(winningLotto);

        LottoHost lottoHost = new LottoHost();
        List<Integer> matchResult = lottoHost.match(generatedLottoNumber, winningLotto);

        YieldCalculator yieldCalculator = new YieldCalculator();
        yieldCalculator.getYield(yieldCalculator.getStatistics(matchResult), purchaseNumber);
    }
}
