package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoSystem {
    public static final int LOTTO_PRICE = 1_000;

    public int purchaseAmount;
    private final List<Lotto> generatedLottos = new ArrayList<>();
    private WinningNumber winningNumber;

    public void execute() {
        purchaseAmount = LottoScanner.readPurchaseAmount();
        generateLottosForPurchaseAmount();
        LottoPrinter.printLotto(generatedLottos);

        winningNumber = LottoScanner.readWinningNumber();
        calculateAndPrintStatistics();
    }

    private void generateLottosForPurchaseAmount() {
        int purchasedLottoCount = purchaseAmount / LOTTO_PRICE;

        for (int i = 0; i < purchasedLottoCount; i++) {
            generatedLottos.add(LottoGenerator.generateRandomly());
        }
    }

    private void calculateAndPrintStatistics() {
        Map<LottoPrize, Integer> statistics = StatisticsCalculator.calculateStatistics(generatedLottos, winningNumber);
        double rateOfReturn = StatisticsCalculator.calculateRateOfReturn(purchaseAmount, statistics);

        LottoPrinter.printStatistics(statistics);
        LottoPrinter.printRateOfReturn(rateOfReturn);
    }
}
