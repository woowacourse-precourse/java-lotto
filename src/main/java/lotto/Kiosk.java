package lotto;

import View.Input;
import View.Output;
import enumCollections.RankNumber;

import java.util.EnumMap;
import java.util.List;

public class Kiosk {
    static final int LOTTO_PRICE = 1000;

    static protected List<Integer> winningNumbers;
    static protected int bonusNumber;

    static public void start(Buyer buyer) {
        try {
            int payment = getPurchaseAmount();
            int numberOfLottos = countLottos(payment);
            List<Lotto> lottos = Generator.generate(numberOfLottos);
            printLottoInformation(numberOfLottos, lottos);
            buyer.buy(lottos);
            winningNumbers = getWinningNumbers();
            bonusNumber = getBonusNumber();
            printResult(Checker.compareAll(buyer), payment);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    static private void printLottoInformation(int numberOfLottos, List<Lotto> lottos) {
        Output.getNumberOfPurchase(numberOfLottos);
        Output.printLottos(lottos);
    }

    static private List<Integer> getWinningNumbers() {
        Output.getWinningNumbers();
        return Input.getWinningNumbers();
    }

    static private int getBonusNumber() {
        Output.getBonusNumber();
        return Input.getBonusNumber(winningNumbers);
    }

    static private void printResult(EnumMap<RankNumber, Integer> resultStatistics, int payment) {
        Output.showResultStatistics(resultStatistics);
        Output.yield(Calculator.getYield(payment, resultStatistics));
    }

    static private int getPurchaseAmount() {
        Output.getPurchaseAmount();
        return Input.getPurchaseMoney();
    }

    static private int countLottos(int payment) {
        return payment / LOTTO_PRICE;
    }
}
