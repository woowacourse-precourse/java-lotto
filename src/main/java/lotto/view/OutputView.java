package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.result.Rank;
import lotto.domain.result.Result;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String COMMA = ", ";
    private static final String NUMBER_OF_PURCHASED_LOTTOS = "%d개를 구매했습니다.";
    private static final String STATISTIC_HEADER = "당첨 통계";
    private static final String STATISTIC_BORDER = "---";
    private static final String STATISTIC_BODY = "%d개 일치%s (%s원) - %d개";
    private static final String MATCH_BONUS_BALL = "보너스 볼 일치";
    private static final String TOTAL_YIELD = "총 수익률은 %.1f%%입니다.";
    private static final int ONE_HUNDRED = 100;

    private static final Map<Integer, String> winnings = new LinkedHashMap<>() {{
        put(2_000_000_000, "2,000,000,000");
        put(30_000_000, "30,000,000");
        put(1_500_000, "1,500,000");
        put(50_000, "50,000");
        put(5_000, "5,000");
    }};

    public static void printLottoCount(LottoCount lottoCount) {
        System.out.print(NEW_LINE);
        System.out.printf(NUMBER_OF_PURCHASED_LOTTOS, lottoCount.getLottoCount());
        System.out.print(NEW_LINE);
    }

    public static void printPurchasedLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> numbers = new ArrayList<>(lotto.get());

            Collections.sort(numbers);
            System.out.println(numbers);
        }
        System.out.print(NEW_LINE);
    }

    public static void printStatistic(Result result) {
        System.out.printf(NEW_LINE);
        System.out.println(STATISTIC_HEADER);
        System.out.println(STATISTIC_BORDER);

        for (Rank rank : Rank.getRankWithoutMiss()) {
            System.out.printf(STATISTIC_BODY, rank.getMatchCount(), getMatchBonusBall(rank),
                    winnings.get(rank.getWinnings()),
                    result.getRankCount(rank));
            System.out.printf(NEW_LINE);
        }
    }

    private static String getMatchBonusBall(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return COMMA + MATCH_BONUS_BALL;
        }
        return "";
    }

    public static void printYield(Result result, Money money) {
        double winnings = result.getWinnings();
        double yield = (winnings / money.getMoney()) * ONE_HUNDRED;
        System.out.printf(TOTAL_YIELD, yield);
    }
}
