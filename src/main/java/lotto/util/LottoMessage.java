package lotto.util;

public enum LottoMessage {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    QUANTITY("개를 구매했습니다."),
    INPUT_WINNING_LOTTO("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
