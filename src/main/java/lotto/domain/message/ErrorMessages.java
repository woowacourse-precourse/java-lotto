package lotto.domain.message;

public enum ErrorMessages {
    LOTTO_NUM_NUMBER_ERROR("[ERROR] 로또 번호 개수가 6개여야 합니다."),
    LOTTO_NUM_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUM_DUPLICATE_ERROR("[ERROR] 로또 번호는 서로 중복되지 않아야 합니다."),
    LOTTO_NUM_FORMAT_ERROR("[ERROR] 로또 번호는 정수형 숫자여야 합니다."),
    MONEY_NOT_INTEGER("[ERROR] 구입금액은 정수형 숫자여야 합니다."),
    MONEY_UNDER_1000("[ERROR] 구입금액은 1,000원 이상이어야 합니다."),
    MONEY_NOT_DIVIDED_BY_1000("[ERROR] 구입금액은 1,000원으로 나누어 떨어져야 합니다."),
    BONUS_NUM_FORMAT_ERROR("[ERROR] 보너스 번호는 정수형 숫자여야 합니다."),
    BONUS_NUM_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUM_DUPLICATE_ERROR("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");

    final private String message;

    public String get() {
        return message;
    }

    ErrorMessages(String message) {
        this.message = message;
    }
}