package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.constant.PrintMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.constant.Rank;

public class OutputView {
    static final String YIELD_PATTERN = "#,###.#";
    static StringBuilder sb;
    static DecimalFormat df;

    public static void printResult(LottoResult lottoResult, double yield) {
        System.out.println((PrintMessage.LOTTO_RESULT_STATISTIC));
        Rank[] ranks = Rank.values();
        for (int rankIndex = ranks.length - 2; rankIndex >= 0; rankIndex--) {
            Rank value = ranks[rankIndex];
            String rankOutputFormat = value.getOutputMessage();
            System.out.println(String.format(rankOutputFormat, lottoResult.getRankCounts(rankIndex + 1)));
        }
        df = new DecimalFormat(YIELD_PATTERN);
        System.out.println(String.format(PrintMessage.LOTTO_RESULT_YIELD.getString(), df.format(yield)));
    }


    public static void printLottos(int count, List<Lotto> lottos) {
        System.out.println((String.format(PrintMessage.LOTTO_BUY.getString(), count)));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLotto());
        }
    }
}
