package lotto.view.output;

import java.text.DecimalFormat;
import lotto.model.Prize;
import lotto.model.Result;

public class SummaryView {
    // TODO 매개변수 너무 많음. 효율화 고민.
    public static void showResult(Result result) {
        System.out.printf("%n당첨 통계%n");
        System.out.println("---");
        for (Prize e : Prize.values()) {
            if (e.equals(Prize.SECOND)) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개" + "%n", e.getMatchingCount(),
                        intToCommaString(e.getReward()), result.getPrizeCount().get(e));
                continue;
            }
            System.out.printf("%d개 일치 (%s원) - %d개" + "%n", e.getMatchingCount(), intToCommaString(e.getReward()),
                    result.getPrizeCount().get(e));
        }
    }

    private static String intToCommaString(long number) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        String commaStr = decFormat.format(number);
        return commaStr;
    }

    // TODO 매개변수 너무 많음. 효율화 고민 too.
    public static void showEarning(Result result, int amount) {
        float prizeMoney = 0;
        for (Prize e : Prize.values()) {
            prizeMoney += (e.getReward() * result.getPrizeCount().get(e));
            System.out.println(prizeMoney);
        }
        float f = (prizeMoney / (amount * 1_000)) * 100;
        System.out.println();
        System.out.println("총 수익률은 " + String.format("%.1f", f) + "%입니다.");
    }
}
