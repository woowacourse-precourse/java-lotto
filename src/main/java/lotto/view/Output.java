package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class Output {
    public static final String INPUT_PURCHASING_MONEY = "구입금액을 입력해 주세요.";

    public static void printGuidingInputPurchasingAmount() {
        System.out.println(Output.INPUT_PURCHASING_MONEY);
    }

    public static void printLottoHistory(List<Lotto> container) {
        int numbers = container.size();
        System.out.println(numbers + Lotto.LOTTO_UNIT + "를 구매했습니다.");
        for (int index = 0; index < numbers; index++) {
            System.out.println(container.get(index).toString());
        }
    }
}
