package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoSystem {
    public static final int LOTTO_PRICE = 1_000;

    public void execute() {
        int lottoCount = calculateLottoCountForPurchasedAmount();
        List<Lotto> generatedLottos = generateRandomLottos(lottoCount);
        printGeneratedLottosCountAndNumbers(generatedLottos);

        WinningNumber winningNumber = LottoScanner.readWinningNumber();
        calculateAndPrintStatistics(generatedLottos, winningNumber);
    }

    private int calculateLottoCountForPurchasedAmount() {
        int purchaseAmount = LottoScanner.readPurchaseAmount();
        return purchaseAmount / LOTTO_PRICE;
    }

    private void printGeneratedLottosCountAndNumbers(List<Lotto> generatedLottos) {
        LottoPrinter.printPurchasedLottoCount(generatedLottos.size());
        generatedLottos.forEach(LottoPrinter::joinNumbersWithDelimiterAndPrint);
    }

    private List<Lotto> generateRandomLottos(int purchasedLottoCount) {
        List<Lotto> newLottos = new ArrayList<>();
        for (int i = 0; i < purchasedLottoCount; i++) {
            newLottos.add(LottoGenerator.generateRandomly());
        }
        return newLottos;
    }

    private void calculateAndPrintStatistics(List<Lotto> generatedLottos, WinningNumber winningNumber) {
        Map<LottoPrize, Integer> statistics = StatisticsCalculator.calculateStatistics(generatedLottos, winningNumber);
        LottoPrinter.printStatistics(statistics);

        int purchaseAmount = generatedLottos.size() * LOTTO_PRICE;
        double rateOfReturn = StatisticsCalculator.calculateRateOfReturn(purchaseAmount, statistics);
        LottoPrinter.printRateOfReturn(rateOfReturn);
    }
}
