package lotto.application.in;

import lotto.application.input.bonusnumber.BonusNumberInput;
import lotto.application.input.purchasemoney.PurchaseMoneyInput;
import lotto.application.input.winningnumber.WinningNumberInput;
import lotto.application.output.lottoprinter.LottoPrinter;
import lotto.application.output.statisticprinter.WinningStatisticPrinter;
import lotto.application.output.yieldprinter.YieldPrinter;
import lotto.application.service.lottomatcher.LottoMatcher;
import lotto.application.service.lottonumber.LottoNumberGenerator;
import lotto.application.service.statistic.WinningStatistic;
import lotto.application.service.yield.YieldCalculator;
import lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

public class LottoStarter {

    private final PurchaseMoneyInput purchaseMoneyInput;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final LottoPrinter lottoPrinter;
    private final WinningNumberInput winningNumberInput;
    private final BonusNumberInput bonusNumberInput;
    private final LottoMatcher lottoMatcher;
    private final WinningStatistic winningStatistic;
    private final WinningStatisticPrinter winningStatisticPrinter;
    private final YieldCalculator yieldCalculator;
    private final YieldPrinter yieldPrinter;

    public LottoStarter(
            PurchaseMoneyInput purchaseMoneyInput, LottoNumberGenerator lottoNumberGenerator,
            LottoPrinter lottoPrinter, WinningNumberInput winningNumberInput, BonusNumberInput bonusNumberInput,
            LottoMatcher lottoMatcher, WinningStatistic winningStatistic,
            WinningStatisticPrinter winningStatisticPrinter,
            YieldCalculator yieldCalculator, YieldPrinter yieldPrinter) {

        this.purchaseMoneyInput = purchaseMoneyInput;
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.lottoPrinter = lottoPrinter;
        this.winningNumberInput = winningNumberInput;
        this.bonusNumberInput = bonusNumberInput;
        this.lottoMatcher = lottoMatcher;
        this.winningStatistic = winningStatistic;
        this.winningStatisticPrinter = winningStatisticPrinter;
        this.yieldCalculator = yieldCalculator;
        this.yieldPrinter = yieldPrinter;
    }

    public void start() {
        int purchaseMoney = purchaseMoneyInput.inputPurchaseMoney();

        List<Lotto> generatedLottoNumber = lottoNumberGenerator.generateLottoNumber(purchaseMoney);
        lottoPrinter.showGeneratedLottoNumber(generatedLottoNumber);

        List<Integer> winningLotto = winningNumberInput.inputWinningLottoNumbers();
        winningLotto.add(bonusNumberInput.inputWinningLottoBonusNumber(winningLotto));

        List<List<Integer>> matchResult = lottoMatcher.matchWinningLotto(generatedLottoNumber, winningLotto);

        Map<String, Integer> statistic = winningStatistic.extractStatistic(matchResult);
        winningStatisticPrinter.showStatistic(statistic);

        double yield = yieldCalculator.extractYield(statistic, purchaseMoney);
        yieldPrinter.showYield(yield);
    }
}
