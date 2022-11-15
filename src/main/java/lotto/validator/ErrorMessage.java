package lotto.validator;

public enum ErrorMessage {
    INVALID_FORMAT("잘못된 형식의 입력입니다."),
    NOT_ENOUGH_MONEY("구입 최소 금액은 1,000원입니다."),
    DIVISIBLE_WITH_THOUSAND("구입 금액은 1,000원으로 나누어 떨어지는 수여야 합니다."),
    INVALID_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_SIZE("당첨 번호는 6개를 입력해야 합니다."),
    DUPLICATED_NUMBERS("당첨번호는 중복될 수 없습니다."),
    DUPLICATE_BONUS("보너스 번호의 숫자는 당첨번호와 중복될 수 없습니다.");

    private static final String ERROR_MESSAGE_HEAD = "[ERROR] ";

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return ERROR_MESSAGE_HEAD + this.message;
    }
}
