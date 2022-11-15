package lotto;

import lotto.domain.IssuingMachine;
import lotto.domain.PrizeListGenerator;
import lotto.domain.QuantityCalculator;
import lotto.domain.YieldCalculator;
import lotto.ui.input.PriceGetter;
import lotto.ui.output.LotteryListPrinter;
import lotto.ui.output.PrizeListPrinter;
import java.util.List;
import java.util.Map;

public class Controller {
    private PriceGetter priceGetter = new PriceGetter();
    private LotteryListPrinter lotteryListPrinter = new LotteryListPrinter();
    private PrizeListPrinter prizeListPrinter = new PrizeListPrinter();
    private IssuingMachine issuingMachine = new IssuingMachine();
    private PrizeListGenerator prizeListGenerator;

    public void lottery() {
        try {
            int buyingAmount = getBuyingAmount();

            List<Lotto> lotteries = issuingMachine.makeLotteryList(buyingAmount);
            lotteryListPrinter.printAllLottery(lotteries);
            Map<Enum, Integer> winnerResult = getWinnerResult(lotteries);

            int buyingMoney = buyingAmount * ConstValue.Numbers.PRICE_PER_LOTTO;
            double yield = YieldCalculator.computeYield(buyingMoney, winnerResult);
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
