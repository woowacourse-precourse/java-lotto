package lotto.ui;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class Output {
    private static final String buyLottoMessage = "개를 구매했습니다.";
    private static final String statisticsMessage = "\n당첨통계\n---";
    private static final String revenueMessage = "총 수익률은 ";

    public static void outputBuyLotto(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + buyLottoMessage);

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void outputStatistics(List<Integer> result, double revenue) {
        System.out.println(statisticsMessage);
        for (int i = 0; i < Rank.length; i++) {
            Rank rank = Rank.getRank(i);
            System.out.println(rank.getMessage() + result.get(rank.getIndex()) + "개");
        }
        System.out.println(revenueMessage + revenue + "%입니다.");
    }
}
