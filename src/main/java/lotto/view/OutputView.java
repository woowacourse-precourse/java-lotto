package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Reward;

public class OutputView {
    public static final String INFORM_AMOUNT = "%d개를 구매했습니다.\n";
    public static final String LOTTO_SECOND = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    public static final String LOTTO_RESULT = "%d개 일치 (%s원) - %d개\n";
    public static final String INFORM_YIELD = "총 수익률은 %s%%입니다.";
    public static final String STATISTICS = "당첨 통계";
    public static final String THREE_HYPHEN = "---";
    public static final String THOUSANDS_COMMA = "###,###";

    public static void printUserLotto(List<Lotto> userLotto) {
        System.out.printf(INFORM_AMOUNT, userLotto.size());
        userLotto.stream()
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printStatistics(int amount, Map<Reward, Integer> result) {
        System.out.println();
        System.out.println(STATISTICS);
        System.out.println(THREE_HYPHEN);
        printResult(result);
        printYield(amount, result);
    }

    public static void printResult(Map<Reward, Integer> result) {
        DecimalFormat decimalFormat = new DecimalFormat(THOUSANDS_COMMA);
        for (Reward r : result.keySet()) {

            if (r == Reward.SECOND) {
                System.out.printf(
                        LOTTO_SECOND, r.getCount(), decimalFormat.format(r.getReward()),
                        result.get(r)
                );
                continue;
            }
            System.out.printf(
                    LOTTO_RESULT, r.getCount(), decimalFormat.format(r.getReward()), result.get(r));
        }
    }

    public static void printYield(int amount, Map<Reward, Integer> result) {
        int sum = 0;
        for (Reward r : result.keySet()) {
            sum += r.getReward() * result.get(r);
        }
        String yield = String.format("%.1f", (double) sum / (double) (amount * 1000) * 100.0);
        System.out.printf(INFORM_YIELD, yield);
    }
}