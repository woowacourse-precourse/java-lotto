package lotto.message;

import lotto.Hit;

public class MessageGenerator {
    private static final String PURCHASE_COUNT_MESSAGE_TEMPLATE = "개를 구매했습니다.";

    public static String getPurchaseConfirmMessage(Integer count) {
        return count + PURCHASE_COUNT_MESSAGE_TEMPLATE;
    }

    public static String getEarningRateMessage(Float earningRate) {
        return "총 수익률은 " + String.format("%.1f", earningRate) + "%입니다.";
    }

    public static String getLottoResultMessage(Hit hit, Integer count) {
        String message = "";
        int hitCount = hit.getHitCount();

        message += hitCount + "개 일치";

        if (hit.requireBonus()) {
            message += ", 보너스 볼 일치";
        }

        message += " (" + hit.getPrize() + "원)";

        message += " - " + count + "개";

        return message;
    }
}
