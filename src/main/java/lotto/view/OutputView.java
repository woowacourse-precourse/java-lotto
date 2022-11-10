package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class OutputView {
    static StringBuilder sb;
    static String YIELD_PATTERN = "#,###.#";
    static DecimalFormat df;

    public static void printResult(LottoResult lottoResult, double yield) {
        System.out.println(("당첨 통계\n---"));
        Rank[] ranks = Rank.values();
        for (int rankIndex = ranks.length - 2; rankIndex >= 0; rankIndex--) {
            Rank value = ranks[rankIndex];
            String rankOutputFormat = value.getOutputMessage();
            System.out.println(String.format(rankOutputFormat, lottoResult.getRankCounts(rankIndex + 1)));
        }
        df = new DecimalFormat(YIELD_PATTERN);
        System.out.println(String.format("총 수익률은 %s%%입니다.", df.format(yield)));
    }


    public static void printLottos(int count, List<Lotto> lottos) {
        System.out.println((String.format("%d개를 구매했습니다.", count)));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLotto());
        }
    }
}
