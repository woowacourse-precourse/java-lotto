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

//    private final static IllegalArgumentException ie = new IllegalArgumentException("[ERROR] 1000 원 단위의 숫자를 입력해주세요!");
    private PriceGetter priceGetter = new PriceGetter();
    private LotteryListPrinter lotteryListPrinter = new LotteryListPrinter();
    private PrizeListPrinter prizeListPrinter = new PrizeListPrinter();

    private IssuingMachine issuingMachine = new IssuingMachine();
    private PrizeListGenerator prizeListGenerator;
    private YieldCalculator yieldCalculator = new YieldCalculator();

    public void lottery() {
        try {
            int price = priceGetter.getBuyingMoney();
            int buyingAmount = QuantityCalculator.calculateProperQuantity(price);

            List<Lotto> lotteryList = issuingMachine.makeLotteryList(buyingAmount);

            lotteryListPrinter.printAllLottery(lotteryList);

            prizeListGenerator = new PrizeListGenerator();
            prizeListGenerator.iterateLotteriesForStatistic(lotteryList);
            Map<Enum, Integer> winnerResult = prizeListGenerator.returnWinnerResult();

            double yield = yieldCalculator.computeYield(buyingAmount * 1000, winnerResult);

            prizeListPrinter.printWinStatistic(winnerResult, yield);
        } catch (IllegalArgumentException ie) {
            System.out.println(ie.getMessage());
            return;
        }
    }
}
