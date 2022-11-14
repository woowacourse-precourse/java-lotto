package lotto.view;

public enum ViewMessage {
    INPUT_MONEY("구매금액을 입력해 주세요."),
    INPUT_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_BUY_LOTTO("개를 구매했습니다.");
    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
