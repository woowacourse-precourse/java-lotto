package lotto;

import lotto.UI.*;
import lotto.domain.*;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        Publisher publisher = new Publisher(purchaseAmount);
        publisher.issueLotto();
        Output.printLotteries(publisher.getLotteries());

        Lotto winNumber = getWinNumber();
        int bonusNumber = getBonusNumber();
        Dealer dealer = new Dealer(publisher, winNumber, bonusNumber);
        List<Integer> result = dealer.getResult();
        float earningRate = dealer.getEarningRate();

        String resultPrintFormat = getPrintResultFormat(result);
        Output.printResult(resultPrintFormat);
        Output.printEarningRate(earningRate);
    }

    static String getPrintResultFormat(List<Integer> result) {
        StringBuilder resultPrintFormat = new StringBuilder();
        for (Ranking ranking : Ranking.values()) {
            int count = result.get(ranking.value());
            resultPrintFormat.append(String.format(ranking.printFormat(), count));
        }
        return resultPrintFormat.toString();
    }

    static int getPurchaseAmount() {
        try {
            return Input.getAnswerInInteger(Request.purchaseAmount.value());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 숫자여야 합니다.");
        }
    }

    static Lotto getWinNumber() {
        try {
            List<Integer> numbers = new ArrayList<>();
            for (String number : Input.getAnswer(Request.winNumber.value()).split(",")) {
                numbers.add(Integer.parseInt(number));
            }
            return new Lotto(numbers);
        } catch (Exception e) { // 숫자가 아닌 문자인 경우
            throw new IllegalArgumentException(
                    "[ERROR] 로또 번호는 쉼표(,)로 구분된 1부터 45 사이의 6자리 숫자여야 합니다");
        }
    }

    static int getBonusNumber() {
        return Input.getAnswerInInteger(Request.bonusNumber.value());
    }
}
