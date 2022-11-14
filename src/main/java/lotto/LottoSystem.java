package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoSystem {
    public static final int LOTTO_PRICE = 1_000;

    public int money;
    private final List<Lotto> generatedLottos = new ArrayList<>();

    private WinningNumber winningNumber;

    public void execute() {
        money = LottoScanner.readMoney();
        int generateCount = money / LOTTO_PRICE;

        for (int i = 0; i < generateCount; i++) {
            generatedLottos.add(LottoGenerator.generate());
        }
        LottoPrinter.printLotto(generatedLottos);

        winningNumber = LottoScanner.readWinningNumber();

        calculateAndPrintStatistics();
    }

    private void calculateAndPrintStatistics() {
        Map<LottoPrize, Integer> statistics = StatisticsCalculator.calculateStatistics(generatedLottos, winningNumber);
        double rateOfReturn = StatisticsCalculator.calculateRateOfReturn(money, statistics);

        LottoPrinter.printStatistics(statistics);
        LottoPrinter.printRateOfReturn(rateOfReturn);
    }
}
