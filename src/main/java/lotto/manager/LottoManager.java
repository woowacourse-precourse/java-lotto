package lotto.manager;

import lotto.view.*;
import lotto.domain.BuyingLotto;
import lotto.domain.Lotto;
import lotto.domain.Winning;
import lotto.domain.WinningTable;
import lotto.util.Statistics;

import java.util.List;
import java.util.Map;

public class LottoManager {
    private int original;
    private InputView inputView;
    private OutputView outputView;

    public void run() {
        try {
            inputView = new InputView();
            outputView = new OutputView();
            List<Lotto> lottos = buy();
            Winning winning = inputWinning();
            printStatistics(winning.getWinningInfo(lottos));
        } catch (Exception e) {
            e.printStackTrace();
            outputView.printException(e.getMessage());
        }
    }

    private void printStatistics(List<WinningTable> winningInfo) {
        Map<WinningTable, Integer> winningMap = Statistics.winningTableListToMap(winningInfo);
        outputView.printStatistics(winningMap,calProfitRate(winningInfo));
    }

    private Winning inputWinning() {
        outputView.printWinningInput();
        List<Integer> winningNumbers = inputView.inputNumbers();
        outputView.printBonusInput();
        int bonus = inputView.inputBonus();
        return new Winning(winningNumbers, bonus);
    }

    private List<Lotto> buy() {
        outputView.printInputPrice();
        original = inputView.inputPrice();
        BuyingLotto buyingLotto = new BuyingLotto(original);
        List<Lotto> lottos = buyingLotto.getLottos();
        outputView.printLottos(lottos);

        return lottos;
    }

    private double calProfitRate(List<WinningTable> winningInfo) {
        List<Integer> winningPrices = Statistics.calWinningPricesFromWinningInfo(winningInfo);
        int profit = Statistics.sum(winningPrices);
        return Statistics.calProfitRate(original, profit);
    }

}
