package lotto.view;

import static lotto.util.CharacterUnits.ENTER;

public enum OutputViewMessage {
    NOTICE_WINNER_STATISTIC("당첨 통계" + ENTER.getUnit() + "---" + ENTER.getUnit()),
    NOTICE_WINNER_LOTTO_RESULT("%d개 일치 (%s원) - %d개" + ENTER.getUnit()),
    NOTICE_WINNER_LOTTO_RESULT_WITH_BONUS_BALL("%d개 일치, 보너스 볼 일치 (%s원) - %d개" + ENTER.getUnit()),
    NOTICE_TOTAL_RATE("총 수익률은 %.1f%s입니다." + ENTER.getUnit());

    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
