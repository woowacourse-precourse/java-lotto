package lotto.constant;

public enum MessageConstant {
    INPUT_MESSAGE("구입 금액을 입력해주세요."),
    PURCHASE_MESSAGE("%d개를 구매했습니다."),
    WIN_MESSAGE("당첨 번호를 입력해주세요."),
    BONUS_MESSAGE("보너스 번호를 입력해 주세요"),
    RESULT_MESSAGE("당첨 통계\n---"),
    COUNT_MESSAGE("%d개 일치 (%s원) - %d개"),
    YIELD_MESSAGE("총 수익률은 %f%입니다."),
    BONUS_COUNT("5개 일치, 보너스 볼 일치 (%s원) - %d개");

    private final String message;

    MessageConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
