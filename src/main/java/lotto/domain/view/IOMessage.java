package lotto.domain.view;

public enum IOMessage {
    INPUT_PURCHASE_LOTTO("구입금액을 입력해 주세요."),
    INPUT_DESIGNATE_FIRSTPLCAE("당첨 번호를 입력해 주세요."),
    INPUT_DESIGNATE_BONUS("보너스 번호를 입력해 주세요."),

    OUTPUT_PURCHASE_LOTTO("개를 구매했습니다."),
    OUTPUT_LOTTO_RESULT_HEAD("당첨 통계\n---"),
    OUTPUT_STANDARD_STATISTICS("%s개 일치 (%s원) - %d개"),
    OUTPUT_BONUS_STATISTICS("%s개 일치, 보너스 볼 일치 (%s원) - %d개"),
    OUTPUT_YIELD_MESSAGE("총 수익률은 %.1f%%입니다.");


    private final String message;

    IOMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
