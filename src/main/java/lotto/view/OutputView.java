package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public static void printAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printTotalAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        }
    }
}
