package lotto.view;

import lotto.domain.lotto.Lotto;

import java.util.Arrays;
import java.util.List;

public class BuyLottoView {
    public static void ask() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printNumberOfLotto(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLotteryNumbers(lotto);
        }
    }

    private static void printLotteryNumbers(Lotto lotto) {
        System.out.println(Arrays.toString(Arrays.stream(lotto.getNumbers().toArray()).sorted().toArray()));
    }
}
