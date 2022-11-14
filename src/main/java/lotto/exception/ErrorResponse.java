package lotto.exception;

public enum ErrorResponse {

    BAD_INPUT_STRING(new IllegalArgumentException("[ERROR] 올바르지 않은 입력 형식입니다.")),
    DUPLICATED_LOTTO_NUMBER(new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.")),
    BAD_LENGTH_LOTTO_NUMBERS(new IllegalArgumentException("[ERROR] 올바르지 않은 로또 번호 길이입니다.")),
    BAD_RANGE_LOTTO_NUMBERS(new IllegalArgumentException("[ERROR] 로또 번호는 1-45 범위를 벗어날 수 없습니다.")),
    BAD_BONUS_LOTTO_NUMBER(new IllegalArgumentException("[ERROR] 보너스 숫자를 입력해주셔야합니다."));
    private final IllegalArgumentException exception;

    ErrorResponse(IllegalArgumentException exception) {
        this.exception = exception;
    }

    public IllegalArgumentException exception() {
        return this.exception;
    }
}
