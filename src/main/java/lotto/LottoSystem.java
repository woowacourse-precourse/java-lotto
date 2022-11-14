package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LottoSystem {
    public static final int LOTTO_PRICE = 1_000;

    public int money;
    private int generateCount;
    private final List<Lotto> generatedLottos= new ArrayList<>();

    private WinningNumber winningNumber;

    public void execute() {
        money = LottoScanner.readMoney();
        generateCount = money / LOTTO_PRICE;

        for (int i = 0; i < generateCount; i++) {
            generatedLottos.add(LottoGenerator.generate());
        }
        LottoPrinter.printLotto(generatedLottos);

        winningNumber = LottoScanner.readWinningNumber();

        calculateAndPrintStatistics();
    }

    private void calculateAndPrintStatistics() {
        Map<LottoPrize, Integer> statistics = calculateStatistics();
        double rateOfReturn = calculateRateOfReturn(money, statistics);

        LottoPrinter.printStatistics(statistics);
        LottoPrinter.printRateOfReturn(rateOfReturn);
    }

    private Map<LottoPrize, Integer> calculateStatistics() {
        Map<LottoPrize, Integer> statistics = initializeCountPerPrize();
        generatedLottos.forEach(lotto -> {
            compareAndCountMatchLotto(statistics, lotto);
        });
        return statistics;
    }

    private void compareAndCountMatchLotto(Map<LottoPrize, Integer> statistics, Lotto lotto) {
        ComparisonToWinningNumberResult result = LottoComparator.compare(lotto, winningNumber);
        LottoPrize prizeOfResult = LottoPrize.of(result);
        int preStatistics = statistics.get(prizeOfResult);
        statistics.put(prizeOfResult, preStatistics + 1);
    }

    private static Map<LottoPrize, Integer> initializeCountPerPrize() {
        Map<LottoPrize, Integer> statistics = new HashMap<>();
        for (LottoPrize prize : LottoPrize.values()){
            statistics.put(prize, 0);
        }
        return statistics;
    }

    private double calculateRateOfReturn(int principal,Map<LottoPrize, Integer> statistics) {
        double sumOfReward = 0;
        for (Entry<LottoPrize, Integer> prizeToCount: statistics.entrySet()) {
            sumOfReward += prizeToCount.getKey().reward * prizeToCount.getValue();
        }
        return Math.round(sumOfReward/principal*100*10)/10.0;
    }
}
