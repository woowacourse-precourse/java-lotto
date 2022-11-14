package lotto;

enum ErrorMessage {
    RANGE_OUT("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_UNIQUE("[ERROR] 로또 번호는 중복 되지 않은 숫자여야 합니다."),
    SIZE_IS_NOT_SIX("[ERROR] 로또 번호는 6개의 숫자여야 합니다."),
    IS_NOT_DIVISIBLE_BY_1000("[ERROR] 구입 금액이 1000원 단위가 아닙니다."),
    IS_LACK("[ERROR] 구입 금액은 최소 1000원 이상이여야 합니다."),
    IS_NOT_INTEGER("[ERROR] 입력 받은 금액이 정수가 아닙니다."),
    DO_NOT_BE_CONTAINED_LOTTO_NUMBERS("[ERROR] 보너스 번호는 당첨 번호와 다른 숫자여야 합니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return errorMessage;
    }
}