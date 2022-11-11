package lotto.validation;

public enum ErrorMessage {
    BLANK_EXCEPTION("[ERROR] 금액을 입력해 주세요."),
    NUMBER_EXCEPTION("[ERROR] 숫자만 입력해 주세요."),
    ZERO_EXCEPTION("[ERROR] 0원을 입력할 수 없습니다. 1,000원 이상 입력해 주세요."),
    CHANGES_EXCEPTION("[ERROR] 잔돈이 있습니다. 1,000원 단위로 입력해 주세요."),
    BLANK_WINNING_EXCEPTION("[ERROR] 당첨 번호를 입력해 주세요."),
    NUMBER_COMMA_WINNING_EXCEPTION("[ERROR] 당첨 번호 6개를 쉼표(,)를 기준으로 구분해 입력해 주세요."),
    CORRECT_RANGE_WINNING_EXCEPTION("[ERROR] 당첨 번호는 1 부터 45 사이의 숫자로 입력해 주세요."),
    CORRECT_SIZE_WINNING_EXCEPTION("[ERROR] 당첨 번호는 총 6개 입니다. 6개의 당첨 번호를 입력해 주세요."),
    DUPLICATE_WINNING_EXCEPTION("[ERROR] 중복된 당첨 번호가 존재합니다. 당첨 번호를 다시 입력해 주세요."),
    NUMBER_BONUS_EXCEPTION("[ERROR] 보너스 번호는 1 부터 45 사이의 숫자 1개 만 입력해 주세요."),
    CONTAIN_BONUS_EXCEPTION("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다. 보너스 번호를 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
