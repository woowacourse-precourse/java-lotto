package lotto.view;

public enum GuideMessage {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    INPUT_PREDICTION_NUMBERS("\n" + "당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n" + "보너스 번호를 입력해 주세요.");

    private final String message;

    GuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
