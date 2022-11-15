package lotto.View;

public enum InputMessage {
    PLEASE_INPUT_BUDGET("구입금액을 입력해 주세요."),
    PLEASE_INPUT_WIN_NUMBER("당첨번호를 입력해 주세요."),

    PLEASE_INPUT_EXTRA_NUMBER("보너스 번호를 입력해 주세요."),

    PURCHASE_NUMBER_OF_GAME("개를 구매했습니다.");

    private final String value;

    InputMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
