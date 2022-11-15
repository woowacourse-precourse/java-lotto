package lotto;

import lotto.application.input.bonusnumber.BonusNumberInput;
import lotto.application.input.bonusnumber.BonusNumberInputImpl;
import lotto.application.input.purchasemoney.PurchaseMoneyInput;
import lotto.application.input.purchasemoney.PurchaseMoneyInputImpl;
import lotto.application.input.winningnumber.WinningNumberInput;
import lotto.application.input.winningnumber.WinningNumberInputImpl;
import lotto.application.output.inputguideprinter.InputGuidePrinter;
import lotto.application.output.inputguideprinter.InputGuidePrinterImpl;
import lotto.application.output.lottoprinter.LottoPrinter;
import lotto.application.output.lottoprinter.LottoPrinterImpl;
import lotto.application.output.statisticprinter.WinningStatisticPrinter;
import lotto.application.output.statisticprinter.WinningStatisticPrinterImpl;
import lotto.application.output.yieldprinter.YieldPrinter;
import lotto.application.output.yieldprinter.YieldPrinterImpl;
import lotto.application.service.lottomatcher.LottoMatcher;
import lotto.application.service.lottomatcher.LottoMatcherImpl;
import lotto.application.service.lottonumber.LottoNumberGenerator;
import lotto.application.service.lottonumber.LottoNumberGeneratorImpl;
import lotto.application.service.statistic.WinningStatistic;
import lotto.application.service.statistic.WinningStatisticImpl;
import lotto.application.service.yield.YieldCalculator;
import lotto.application.service.yield.YieldCalculatorImpl;
import lotto.application.util.inputagent.InputAgent;
import lotto.application.util.inputagent.InputAgentImpl;

public class ContextFactory {

    public InputAgent getInputAgent() {
        return new InputAgentImpl();
    }

    public InputGuidePrinter getInputGuidePrinter() {
        return new InputGuidePrinterImpl();
    }

    public PurchaseMoneyInput getPurchaseMoneyInput() {
        return new PurchaseMoneyInputImpl(getInputAgent(), getInputGuidePrinter());
    }

    public WinningNumberInput getWinningNumberInput() {
        return new WinningNumberInputImpl(getInputAgent(), getInputGuidePrinter());
    }

    public BonusNumberInput getBonusNumberInput() {
        return new BonusNumberInputImpl(getInputAgent(), getInputGuidePrinter());
    }

    public LottoNumberGenerator getLottoNumberGenerator() {
        return new LottoNumberGeneratorImpl();
    }

    public LottoPrinter getLottoPrinter() {
        return new LottoPrinterImpl();
    }

    public LottoMatcher getLottoMatcher() {
        return new LottoMatcherImpl();
    }

    public WinningStatistic getWinningStatistic() {
        return new WinningStatisticImpl();
    }

    public WinningStatisticPrinter getWinningStatisticPrinter() {
        return new WinningStatisticPrinterImpl();
    }

    public YieldCalculator getYieldCalculator() {
        return new YieldCalculatorImpl();
    }

    public YieldPrinter getYieldPrinter() {
        return new YieldPrinterImpl();
    }
}
