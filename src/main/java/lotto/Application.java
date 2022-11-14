package lotto;

import lotto.domain.*;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        // 사용자에게 복권 구입 금액을 입력받는다.
        int purchaseAmount = getPurchaseAmount();
        Publisher publisher = new Publisher(purchaseAmount);
        // 구입하는 복권 수만큼 복권 번호를 사용자로부터 입력받는다.
        issueLotteries(publisher);
        // 구입하는 복권 수량과 정렬된 복권 번호를 출력한다.
        UI.printLotteries(publisher.getLotteries());
        // 복권 추첨을 시행하고 결과를 확인한다.
        List<Integer> result = publisher.make();
        // 결과를 출력한다.
        UI.printResult(result);

    }
    static int getPurchaseAmount() {
        try {
            int purchaseAmount = UI.getAnswerInInteger(Request.purchaseAmount.value());
            return purchaseAmount;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 숫자여야 합니다.");
        }
    }

    static void issueLotteries(@NotNull Publisher publisher) {
        while (publisher.getLotteries().size() < publisher.getTicketQuantity()) {
            try {
                List<Integer> numbers = new ArrayList<>();
                for (String number: UI.getAnswer(Request.winNumber.value()).split(",")) {
                    numbers.add(Integer.parseInt(number));
                }
                publisher.issueLotto(numbers);
            } catch (Exception e) { // 숫자가 아닌 문자인 경우
                throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표(,)로 구분된 1부터 45 사이의 6자리 숫자여야 합니다");
            }
        }
    }
}
