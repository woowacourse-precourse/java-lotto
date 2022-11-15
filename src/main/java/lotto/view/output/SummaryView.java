package lotto.view.output;

import java.text.DecimalFormat;
import lotto.model.Prize;
import lotto.model.Result;

public class SummaryView {
    private static final String START_MESSAGE = "%n당첨 통계%n";
    private static final String UNDER_BAR = "----%n";
    private static final String GENERIC_SUMMARY_MESSAGE = "%d개 일치 (%s원) - %d개" + "%n";
    private static final String SECOND_PRIZE_SUMMARY_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개" + "%n";
    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void showResult(Result result) {
        System.out.printf(START_MESSAGE + UNDER_BAR);
        for (Prize e : Prize.values()) {
            if (e.equals(Prize.SECOND)) {
                System.out.printf(SECOND_PRIZE_SUMMARY_MESSAGE, e.getMatchingCount(), intToCommaString(e.getReward()),
                        result.getPrizeCount().get(e));
                continue;
            }
            System.out.printf(GENERIC_SUMMARY_MESSAGE, e.getMatchingCount(), intToCommaString(e.getReward()),
                    result.getPrizeCount().get(e));
        }
    }

    private static String intToCommaString(long number) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        return decFormat.format(number);
    }

    public static void showEarning(Result result, int amount) {
        float prizeMoney = 0;
        for (Prize e : Prize.values()) {
            prizeMoney += (e.getReward() * result.getPrizeCount().get(e));
        }
        float f = (prizeMoney / (amount * 1_000)) * 100;
        System.out.printf(EARNING_RATE_MESSAGE, f);
    }
}
