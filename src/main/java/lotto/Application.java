package lotto;

import lotto.UI.*;
import lotto.domain.*;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Error;

public class Application {

    public static void main(String[] args) {
        try {
            long purchaseAmount = getPurchaseAmount();
            Publisher publisher = new Publisher(purchaseAmount);
            Output.printLotteries(publisher.getLotteries());

            Dealer dealer = new Dealer(publisher.getLotteries(), getWinNumber(), getBonusNumber());
            List<Integer> result = dealer.getResult();
            float earningRate = dealer.calculateEarningRate(purchaseAmount);

            String resultPrintFormat = getPrintResultFormat(result);
            Output.printWinningStatistics(resultPrintFormat, earningRate);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getPrintResultFormat(List<Integer> result) {
        StringBuilder resultPrintFormat = new StringBuilder();
        for (Ranking ranking : Ranking.values()) {
            int count = result.get(ranking.value());
            resultPrintFormat.append(String.format(ranking.printFormat(), count));
        }
        return resultPrintFormat.toString();
    }

    private static long getPurchaseAmount() {
        try {
            return Input.getAnswerInLong(Request.purchaseAmount.value());
        } catch (Exception e) {
            throw new IllegalArgumentException(Error.purchaseAmount.value());
        }
    }

    private static Lotto getWinNumber() {
        try {
            List<Integer> numbers = new ArrayList<>();
            for (String number : Input.getAnswer(Request.winNumber.value()).split(",")) {
                numbers.add(Integer.parseInt(number));
            }
            return new Lotto(numbers);
        } catch (Exception e) { // 숫자가 아닌 문자인 경우
            throw new IllegalArgumentException(Error.lotto.value());
        }
    }

    private static Bonus getBonusNumber() {
        int bonusNumber = Input.getAnswerInInteger(Request.bonusNumber.value());
        return new Bonus(bonusNumber);
    }
}
