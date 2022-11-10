package lotto.entity;

public enum InputGuide {
    PURCHASING_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    private InputGuide(String message) {
        this.message = message;
    }
}
