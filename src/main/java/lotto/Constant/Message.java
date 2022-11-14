package lotto.Constant;

public enum Message {
    ERROR_THOUSAND_UNIT("[ERROR] 1000원 단위로 입력해주세요"),
    ERROR_NUMBER("[ERROR] 숫자만 입력해주세요."),
    ERROR_DUPLICATE("[ERROR] 중복된 숫자 없게 입력해주세요."),
    ERROR_ONE_TO_FORTYFIVE("[ERROR] 1~45숫자만 입력해주세요."),
    ERROR_SIZE("[ERROR] 6개의 숫자를 입력해주세요."),
    START("구입금액을 입력해 주세요."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해주세요."),
    BUY_AMOUNT("개를 구매했습니다.");

    private final String message;

    Message(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
