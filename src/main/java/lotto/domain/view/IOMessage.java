package lotto.domain.view;

public enum IOMessage {
    INPUT_PURCHASE_LOTTO("구입금액을 입력해 주세요."),
    INPUT_DESIGNATE_FIRSTPLCAE("당첨 번호를 입력해 주세요."),
    INPUT_DESIGNATE_BONUS("보너스 번호를 입력해 주세요."),

    OUTPUT_PURCHASE_LOTTO("개를 구매했습니다."),
    OUTPUT_LOTTO_RESULT_HEAD("당첨 통계\n---"),
    STANDARD_STATISTICS_MESSAGE("%d개 일치 (%d원) - %d개"),
    BONUS_STATISTICS_MESSAGE("%d개 일치, 보너스 볼 일치 (%d원) - %d개");

    private String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
