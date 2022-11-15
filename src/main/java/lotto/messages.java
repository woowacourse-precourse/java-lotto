package lotto;

public enum messages {

    INVALID_ANSWER("[ERROR] 당첨번호는 쉼표(,)를 기준으로 6개의 서로 다른 숫자를 입력해 주세요."),
    INVALID_BONUS("[ERROR] 보너스 번호는 당첨번호와 중복되지 않는 1부터 45 사이의 숫자를 한 개만 입력해 주세요."),
    INVALID_FORMAT_MONEY("[ERROR] 로또 구입 금액은 숫자로 입력해 주세요."),
    INVALID_NUMBER_MONEY("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해 주세요.");

    private final String errorMsg;

    messages(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
