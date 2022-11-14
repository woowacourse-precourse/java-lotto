package lotto.io;

public enum Message {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_MESSAGE("개를 구매했습니다."),
    GET_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT_INFO("당첨 통계\n---"),
    EACH_RESULT("%d개 일치 (%,d원) - %d개"),
    BONUS_RESULT("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    YIELD_RESULT("총 수익률은 %.1f%%입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
