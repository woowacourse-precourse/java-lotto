package lotto.view;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.Result;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String COMMA = ", ";
    private static final String NUMBER_OF_PURCHASED_LOTTOS = "%d개를 구매했습니다.";
    private static final String STATISTIC_HEADER = "당첨 통계" + NEW_LINE + "---";
    private static final String STATISTIC_BODY = "%d개 일치%s (%s원) - %d개";
    private static final String MATCH_BONUS_BALL = "보너스 볼 일치";
    private static final String TOTAL_YIELD = "총 수익률은 %.1f%%입니다.";
    private static final int ONE_HUNDRED = 100;

    private static final Map<Integer, String> winnings = new LinkedHashMap<>() {{
        put(2000000000, "2,000,000,000");
        put(30000000, "30,000,000");
        put(1500000, "1,500,000");
        put(50000, "50,000");
        put(5000, "5000");
    }};

    public static void printLottoCount(LottoCount lottoCount) {
        System.out.print(NEW_LINE);
        System.out.printf(NUMBER_OF_PURCHASED_LOTTOS, lottoCount.getLottoCount());
        System.out.print(NEW_LINE);
    }

    public static void printPurchasedLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            String lottoNumbers = OPEN_BRACKET
                    + lotto.get()
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(COMMA))
                    + CLOSE_BRACKET;
            System.out.println(lottoNumbers);
        }
        System.out.print(NEW_LINE);
    }

    public static void printResult(Result result) {
        System.out.println(STATISTIC_HEADER);
        for (Rank rank : Rank.get()) {
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
        return " ";
    }

    public static void printYield(Result result, Money money) {
        double winnings = result.getWinnings();
        double yield = (winnings / money.getMoney()) * ONE_HUNDRED;
    }
}
