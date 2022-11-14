package lotto.controller;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoGroup;
import lotto.domain.lotto.WinningNumber;
import lotto.domain.number.PayOut;
import lotto.domain.rule.Rank;
import lotto.domain.rule.Rule;
import lotto.domain.winnings.Winnings;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {

    private static final LottoGenerator lottoGenerator = new LottoGenerator();

    public static void run() {
        PayOut payOut = getPayOut();

        LottoGroup lottoGroup = getPaidLottos(payOut);

        String winningNumbers = getWinningNumbers();
        String bonusNumber = getBonusNumber();
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);

        Map<Rank, Integer> lottoResults = getLottoResults(lottoGroup, winningNumber);

        getStatistics(lottoResults);
        double yield = Winnings.getYield(payOut, lottoResults);
        getYield(yield);
    }

    private static void getYield(double yield) {
        OutputView.printYield(yield);
    }

    private static void getStatistics(Map<Rank, Integer> lottoResults) {
        OutputView.printWinningStatisticsTitle();

        for (Rank rank : lottoResults.keySet()) {
            if (rank != Rank.FAIL) {
                OutputView.printWinningStatistics(rank, lottoResults.get(rank));
            }
        }
    }

    private static Map<Rank, Integer> getLottoResults(LottoGroup lottoGroup, WinningNumber winningNumber) {
        Rule rule = new Rule();

        return rule.getLottoResults(lottoGroup, winningNumber);
    }

    private static String getBonusNumber() {
        OutputView.printBonusNumberInput();

        return InputView.getInput();
    }

    private static String getWinningNumbers() {
        OutputView.printWinningNumberInput();

        return InputView.getInput();

    }

    private static LottoGroup getPaidLottos(PayOut payOut) {
        int gameCount = payOut.getGameCount();
        OutputView.printLottoCount(gameCount);

        LottoGroup lottoGroup = lottoGenerator.generateLottos(gameCount);
        OutputView.printLottoNumbers(lottoGroup);

        return lottoGroup;
    }

    private static PayOut getPayOut() {
        OutputView.payout();

        return new PayOut(InputView.getInput());
    }
}
