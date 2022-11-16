package lotto.model;

public enum Error {

    NUMBER_FORMAT_ERROR("[ERROR] 입력값은 1부터 45 사이의 숫자여야 합니다."),
    PRICE_UNIT_ERROR("[ERROR] 구입 금액은 1,000원 단위여야 합니다."),
    LOTTO_SIZE_ERROR("[ERROR] 로또 번호는 6개의 숫자여야 합니다."),
    LOTTO_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_DUPLICATED_ERROR("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다."),
    WIN_NUMBER_SIZE_ERROR("[ERROR] 당첨 번호는 6개의 숫자여야 합니다."),
    WIN_NUMBER_RANGE_ERROR("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    WIN_NUMBER_DUPLICATED_ERROR("[ERROR] 당첨 번호는 중복되지 않는 숫자여야 합니다."),
    BONUS_NUMBER_RANGE_ERROR("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATED_ERROR("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 숫자여야 합니다."),
    EQUAL_COUNT_ERROR("[ERROR] 일치하는 번호의 개수는 0부터 6 사이의 숫자여야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
