package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class OutputView {
    static StringBuilder sb;
    static String YIELD_PATTERN = "#,###.##";
    static DecimalFormat df;

    public static void printResult(LottoResult lottoResult, double yield) {
        sb = new StringBuilder();
        sb.append("당첨 통계\n---\n");
        for (Rank value : Rank.values()) {
            sb.insert(0, String.format(value.getOutputMessage(), lottoResult.getRankCounts(value.ordinal() + 1)));
        }
        df = new DecimalFormat(YIELD_PATTERN);
        sb.append(String.format("총 수익률은 %s%%입니다.", df.format(yield)));
        System.out.println(sb.toString());
    }


    public static void printLottos(int count, List<Lotto> lottos) {
        System.out.println((String.format("%d개를 구매했습니다.", count)));
        sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.getLotto());
            sb.append("\n");
        }
    }
}
