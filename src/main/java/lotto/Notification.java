package lotto;

public enum Notification {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("%d개를 구매했습니다."),
    INPUT_WIN_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    LOTTO_RESULT("당첨 통계\n---\n3개 일치 (5,000원) - %d개\n4개 일치 (50,000원) - %d개\n5개 일치 (1,500,000원) - %d개\n5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n6개 일치 (2,000,000,000원) - %d개\n총 수익률은 %s입니다.");

    private final String message;

    private Notification(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
