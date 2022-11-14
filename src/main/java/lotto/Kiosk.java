package lotto;

import ExceptionCollections.CommonException;
import ExceptionCollections.PaymentException;
import View.Input;
import View.Output;
import enumCollections.RankNumber;

import java.util.EnumMap;
import java.util.List;

public class Kiosk {
    static final int LOTTO_PRICE = 1000;
    static protected List<Integer> winningNumbers;
    static protected int bonusNumber;
//    static protected EnumMap<RankNumber, Integer> resultStatistics;
    static int payment;

    static public void start(Buyer buyer) {
        payment = getPurchaseAmount();
        int numberOfLottos = countLottos(payment);
        List<Lotto> lottos = Generator.generate(numberOfLottos);
        Output.getNumberOfPurchase(numberOfLottos);
        Output.printLottos(lottos);
        buyer.buy(lottos);
        Output.getWinningNumbers();
        winningNumbers = Input.getWinningNumbers();
        Output.getBonusNumber();
        bonusNumber = Input.getBonusNumber();
        EnumMap<RankNumber, Integer> resultStatistics = Checker.compareAll(buyer);
        Output.showResultStatistics(resultStatistics);
        float yield = Calculator.getYield(payment, resultStatistics);
//        Output.yield(yield);
    }

    static private int getPurchaseAmount() {
        Output.getPurchaseAmount();
        String payment = Input.getPurchaseMoney();
        PaymentException.validate(payment);
        return Integer.valueOf(payment);
    }

    static private int countLottos(int payment) {
        return payment / LOTTO_PRICE;
    }

}
