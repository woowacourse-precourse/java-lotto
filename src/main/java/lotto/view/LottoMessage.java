package lotto.view;

public enum LottoMessage {
    INPUT_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_DONE("개를 구매했습니다."),
    INPUT_NUMBERS("당첨 번호를 입력해 주세요.");

    private final String message;

    LottoMessage(String message) { this.message = message; }
    public String getMessage() { return this.message; }
}
