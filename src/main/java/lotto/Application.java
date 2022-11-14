package lotto;

import lotto.UI.*;
import lotto.domain.*;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class Application {

    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        Publisher publisher = new Publisher(purchaseAmount);

        issueLotteries(publisher);

        Output.printLotteries(publisher.getLotteries());

        Dealer dealer = new Dealer(publisher.getLotteries(), purchaseAmount);
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

    static void issueLotteries(@NotNull Publisher publisher) {
        while (publisher.getLotteries().size() < publisher.getTicketQuantity()) {
            try {
                List<Integer> numbers = new ArrayList<>();
                for (String number : Input.getAnswer(Request.winNumber.value()).split(",")) {
                    numbers.add(Integer.parseInt(number));
                }
                int bonusNumber = (Input.getAnswerInInteger(Request.bonusNumber.value()));
                publisher.issueLotto(numbers, bonusNumber);
            } catch (Exception e) { // 숫자가 아닌 문자인 경우
                throw new IllegalArgumentException(
                        "[ERROR] 로또 번호는 쉼표(,)로 구분된 1부터 45 사이의 6자리 숫자여야 합니다");
            }
        }
    }
}
