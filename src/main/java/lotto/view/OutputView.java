package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public static void messageAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printTotalAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            Object[] sortedLotto = sortAscendingOrder(lotto.getNumbers().toArray());
            System.out.println(Arrays.toString(sortedLotto));
        }
    }

    private static Object[] sortAscendingOrder(Object[] lottoNumbers) {
        Arrays.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static void messageWinningInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void messageBonusInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
