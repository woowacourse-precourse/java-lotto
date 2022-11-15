package lotto;

import View.GuideMessage;
import View.Input;
import View.ResultMessage;
import enumCollections.RankNumber;

import java.util.EnumMap;
import java.util.List;

public class Kiosk {
    public static void start(Buyer buyer) {
        try {
            int payment = getPayment();
            List<Lotto> lottos = Generator.generate(payment);
            printLottoInformation(lottos);
            buyer.buy(lottos);
            List<Integer> winningNumbers = getWinningNumbers();
            int bonusNumber = getBonusNumber(winningNumbers);
            printResult(Checker.compareAllLottos(buyer, winningNumbers, bonusNumber), payment);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void printLottoInformation(List<Lotto> lottos) {
        ResultMessage.printLottoInformation(lottos);
    }

    private static List<Integer> getWinningNumbers() {
        GuideMessage.printWinningNumbersInput();
        return Input.getWinningNumbers();
    }

    private static int getBonusNumber(List<Integer> winningNumbers) {
        GuideMessage.printBonusNumberInput();
        return Input.getBonusNumber(winningNumbers);
    }

    private static void printResult(EnumMap<RankNumber, Integer> resultStatistics, int payment) {
        ResultMessage.printStatistics(resultStatistics);
        ResultMessage.printYield(Calculator.getYield(payment, resultStatistics));
    }

    private static int getPayment() {
        GuideMessage.printPaymentInput();
        return Input.getPayment();
    }
}
