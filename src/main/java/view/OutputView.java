package view;

import domain.Lotto;
import domain.LottoRank;
import domain.LottoResult;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String HOW_MANY_LOTTO = "개를 구매했습니다.";
    private static final String STATISTIC_HEADER = "당첨 통계";
    private static final String STATISTIC_BORDER = "---";
    private static final String HISTORY = "%d개 일치 (%s원) - %d개\n";
    private static final String BONUS_HISTORY = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String PROFIT = "총 수익률은 %.1f%%입니다.";

    private static final DecimalFormat df = new DecimalFormat("###,###");

    public static void showLottos(List <Lotto> lottos) {
        System.out.println(lottos.size() + HOW_MANY_LOTTO);

        lottos.stream().map(Lotto::getNumbers).forEach(System.out::println);
    }

    public static void showResult(Map <LottoRank,Integer> result) {
        System.out.println(STATISTIC_HEADER);
        System.out.println(STATISTIC_BORDER);

        for (LottoRank key : result.keySet()) {
            if (!(key.equals(LottoRank.ZERO) || key.equals(LottoRank.FIVE_WITH_BONUS))) {
                System.out.printf(HISTORY, key.getCount(), df.format(key.getPrize()), result.get(key));
            }

            if (key.equals(LottoRank.FIVE_WITH_BONUS)) {
                System.out.printf(BONUS_HISTORY, key.getCount(), df.format(key.getPrize()), result.get(key));
            }
        }
    }

    public static void showProfitPercent(int purchaseMoney, LottoResult result) {
        System.out.printf(PROFIT, result.profitPercent(purchaseMoney));
    }
}
