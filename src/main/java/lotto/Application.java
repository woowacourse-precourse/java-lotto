package lotto;

import lotto.domain.*;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class Application {

    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
        Publisher publisher = new Publisher(purchaseAmount);

        issueLotteries(publisher);

        UI.printLotteries(publisher.getLotteries());

        Maker maker = new Maker(publisher.getLotteries(), purchaseAmount);
        List<Integer> result = maker.getResult();
        float earningRate = maker.getEarningRate();

        UI.printResult(result);
        UI.printEarningRate(earningRate);
    }

    static int getPurchaseAmount() {
        try {
            return UI.getAnswerInInteger(Request.purchaseAmount.value());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 숫자여야 합니다.");
        }
    }

    static void issueLotteries(@NotNull Publisher publisher) {
        while (publisher.getLotteries().size() < publisher.getTicketQuantity()) {
            try {
                List<Integer> numbers = new ArrayList<>();
                for (String number : UI.getAnswer(Request.winNumber.value()).split(",")) {
                    numbers.add(Integer.parseInt(number));
                }
                int bonusNumber = (UI.getAnswerInInteger(Request.bonusNumber.value()));
                publisher.issueLotto(numbers, bonusNumber);
            } catch (Exception e) { // 숫자가 아닌 문자인 경우
                throw new IllegalArgumentException(
                        "[ERROR] 로또 번호는 쉼표(,)로 구분된 1부터 45 사이의 6자리 숫자여야 합니다");
            }
        }
    }
}
