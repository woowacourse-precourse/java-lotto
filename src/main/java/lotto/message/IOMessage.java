package lotto.message;

public enum IOMessage {
    EMPTY_LINE(""),
    ASK_PRICE("구입금액을 입력해 주세요."),
    LOTTO_BUY_NUM("개를 구매했습니다."),
    ASK_ANSWER("당첨 번호를 입력해 주세요."),
    ASK_BONUS("보너스 번호를 입력해 주세요.");

    private final String message;

    IOMessage(String message) { this.message = message; }
    public String getMessage() { return message; }
}
