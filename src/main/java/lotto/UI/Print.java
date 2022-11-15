package lotto.UI;

import lotto.Lotto;
import lotto.domain.Match;
import lotto.domain.Operation;

import java.text.DecimalFormat;
import java.util.List;

import static lotto.instance.Setting.*;

public class Print {
    public static void getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void userLottos(List<Lotto> lottos, int purchaseAmount) {
        int buyAmount = Operation.buyAmount(purchaseAmount);
        System.out.printf("%d개를 구매했습니다.\n", buyAmount);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void result(double earningRate, Match match) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (" + formatter.format(AMOUNT_THREE) + "원) - %d개\n", match.MATCH_THREE);
        System.out.printf("4개 일치 (" + formatter.format(AMOUNT_FOUR) + "원) - %d개\n", match.MATCH_FOUR);
        System.out.printf("5개 일치 (" + formatter.format(AMOUNT_FIVE) + "원) - %d개\n", match.MATCH_FIVE);
        System.out.printf("5개 일치, 보너스 볼 일치 (" + formatter.format(AMOUNT_FIVE_BONUS) + "원) - %d개\n", match.MATCH_FIVE_BONUS);
        System.out.printf("6개 일치 (" + formatter.format(AMOUNT_SIX) + "원) - %d개\n", match.MATCH_SIX);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningRate);
    }
}
