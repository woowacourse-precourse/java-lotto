package lotto.Utils;

import lotto.Lotto;
import lotto.domain.WinInfo;

import java.util.*;

public class Print {
    public static void askAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void askWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void askBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void purchasedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            lotto.print();
        }
    }
}