package lotto.view;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prize;

public class PrintResult {

    public static void PrintPieces(int pieces) {
        System.out.println(pieces + "개를 구매했습니다.");
    }

    public static void PrintLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void PrintPrizeStatistic(Map<Prize, Integer> prizeBoard) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + prizeBoard.get(Prize.THREE) + "개");
        System.out.println("4개 일치 (50,000원) - " + prizeBoard.get(Prize.FOUR) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + prizeBoard.get(Prize.FIVE) + "개");
        System.out.println(
            "5개 일치, 보너스 볼 일치 (30,000,000원) - " + prizeBoard.get(Prize.FIVE_AND_BOUNS) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + prizeBoard.get(Prize.ALL) + "개");
    }

    public static void PrintProfitRate(float profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

}
