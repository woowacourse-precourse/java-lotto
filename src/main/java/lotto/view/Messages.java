package lotto.view;

public enum Messages {
    REQUEST_BUDGET_INPUT("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBERS_INPUT("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    ERROR_PREFIX("[ERROR] "),
    ERROR_NUMBER_ELEMENT("구입 금액은 0 이상의 숫자만 입력 받습니다."),
    ERROR_MONEY("구입 금액은 1,000원 단위로 입력 받습니다.");


    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public String getErrorMessage() {
        return ERROR_PREFIX.getMessage() + message;
    }
}
