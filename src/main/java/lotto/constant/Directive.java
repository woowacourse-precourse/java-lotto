package lotto.constant;

public enum Directive {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_LOTTO_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");

    private final String message;

    Directive(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
