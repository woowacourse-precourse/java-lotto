package lotto.message;

public enum MessageList {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    NUMBER_OF_PURCHASES("개를 구매했습니다."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONNUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNIG_STATISTICS("당첨 통계"),
    LINE("---");

    private final String message;

    MessageList(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
