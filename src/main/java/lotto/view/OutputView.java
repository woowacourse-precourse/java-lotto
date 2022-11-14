package lotto.view;

import lotto.Lotto;
import java.util.List;

public class OutputView {

    public static void printLottoPurchaseInputNotice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printWinningNumberInputNotice() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputNotice() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printLottoPurchaseResult(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }
}
