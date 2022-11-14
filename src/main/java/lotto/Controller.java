package lotto;

import lotto.domain.IssuingMachine;
import lotto.domain.PrizeListGenerator;
import lotto.domain.QuantityCalculator;
import lotto.domain.YieldCalculator;
import lotto.ui.input.PriceGetter;
import lotto.ui.input.WinnerNumberGetter;
import lotto.ui.output.LotteryListPrinter;
import lotto.ui.output.PrizeListPrinter;

import java.util.List;
import java.util.Map;

public class Controller {
    private static final int MULTIPLIER = 1000;
    private PriceGetter priceGetter = new PriceGetter();
    private LotteryListPrinter lotteryListPrinter = new LotteryListPrinter();
    private PrizeListPrinter prizeListPrinter = new PrizeListPrinter();

    private IssuingMachine issuingMachine = new IssuingMachine();
    private PrizeListGenerator prizeListGenerator;
    private YieldCalculator yieldCalculator = new YieldCalculator();

    public void lottery() {
        try {
            int buyingAmount = getBuyingAmount();

            List<Lotto> lotteryList = issuingMachine.makeLotteryList(buyingAmount);
            lotteryListPrinter.printAllLottery(lotteryList);
            Map<Enum, Integer> winnerResult = getWinnerResult(lotteryList);

            int buyingMoney = buyingAmount * MULTIPLIER;
            double yield = yieldCalculator.computeYield(buyingMoney, winnerResult);
            prizeListPrinter.printWinStatistic(winnerResult, yield);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
        }
    }

    private int getBuyingAmount() {
        int price = priceGetter.getBuyingMoney();
        int buyingAmount = QuantityCalculator.calculateProperQuantity(price);

        return buyingAmount;
    }

    private Map<Enum, Integer> getWinnerResult(List<Lotto> lotteryList) {
        prizeListGenerator = new PrizeListGenerator();
        prizeListGenerator.iterateLotteriesForStatistic(lotteryList);
        Map<Enum, Integer> winnerResult = prizeListGenerator.returnWinnerResult();

        return winnerResult;
    }
}
