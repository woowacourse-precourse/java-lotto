package lotto.domain;

public enum Error {
    PURCHASE_AMOUNT_IS_ZERO("구매 금액은 0원일 수 없습니다."),
    PURCHASE_AMOUNT_IS_NOT_NUMERIC("구매 금액의 입력 형식이 숫자가 아닙니다."),
    PURCHASE_AMOUNT_IS_NOT_DIVIDE_LOTTERY_PRICE("구매 금액이 로또금액으로 나눠 떨어지지 않습니다."),
    LOTTO_NUMBER_IS_NOT_NUMERIC("당첨 번호는 숫자 형식이어야 합니다."),
    LOTTO_NUMBER_IS_NOT_IN_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_IS_NOT_CORRECT_SIZE("로또 번호는 6개의 숫자로 구성되어야 합니다."),
    LOTTO_NUMBERS_IS_CONTAIN_DUPLICATE("로또 번호에는 중복이 없어야 합니다."),
    BONUS_NUMBER_IS_DUPLICATE_WITH_WINNING_NUMBERS("보너스번호는 당첨번호에 포함되지 않는 번호여야 합니다.");

    private static final String MESSAGE_PREFIX = "[ERROR] ";
    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return MESSAGE_PREFIX + message;
    }
}
