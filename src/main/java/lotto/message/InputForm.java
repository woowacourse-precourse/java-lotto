package lotto.message;

public enum InputForm {
    INPUT_PRICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUM("당첨 번호를 입력해 주세요."),
    INPUT_BONUSNUM("보너스 번호를 입력해 주세요.");

    private final String message;

    InputForm(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
