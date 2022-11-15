package lotto.message;

import lotto.Hit;

public class ResultMessageGenerator {
    private static final String PURCHASE_COUNT_MESSAGE_TEMPLATE = "%s개를 구매했습니다.";
    private static final String NET_EARNING_RATE_MESSAGE_TEMPLATE = "총 수익률은 %s%%입니다.";
    private static final String COUNT_MATCH_MESSAGE_TEMPLATE = "%s개 일치%s (%s원) - %s개";
    private static final String BONUS_BALL_MATCH_MESSAGE_TEMPLATE = ", 보너스 볼 일치";
    private static final String BLANK = "";
    private static final String ROUND = "%.1f";

    public static String getPurchaseConfirmMessage(Integer count) {
        return String.format(PURCHASE_COUNT_MESSAGE_TEMPLATE, count);
    }

    public static String getEarningRateMessage(Float earningRate) {
        return String.format(NET_EARNING_RATE_MESSAGE_TEMPLATE, String.format(ROUND, earningRate));
    }

    public static String getLottoResultMessage(Hit hit, Integer count) {
        if (hit.requireBonus()) {
            return String.format(COUNT_MATCH_MESSAGE_TEMPLATE,
                    hit.getHitCount(),
                    BONUS_BALL_MATCH_MESSAGE_TEMPLATE,
                    hit.getPrize(),
                    count
            );
        }

        return String.format(COUNT_MATCH_MESSAGE_TEMPLATE, hit.getHitCount(), BLANK, hit.getPrize(), count);
    }
}
