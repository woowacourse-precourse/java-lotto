package lotto.ui;

public enum ConsoleMessage {
    INPUT_PRICE("구입금액을 입력해 주세요."),

    INVALID_INPUT_PRICE("잘못된 형식의 금액을 입력하셨습니다."),

    USERS_LOTTO_OUTPUT("개를 구매했습니다.");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return message;
    }

}
