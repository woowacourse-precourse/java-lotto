package lotto.Enum;

public enum Message {
    BUY_MONEY("구매금액을 입력해 주세요."),
    BUY_COUNT("개를 구매했습니다."),
    LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    FINAL_FIRST("총 수익률은 "),
    FINAL_LAST("%입니다.");
    private final String message;

    Message(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
