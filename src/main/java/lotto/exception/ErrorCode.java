package lotto.exception;

public enum ErrorCode {
    LOTTO_DUPLICATE_ERROR("로또 숫자에 중복된 값이 있습니다."),
    LOTTO_SIZE_ERROR("로또 숫자는 6개여야 합니다."),
    LOTTO_BOUND_ERROR("로또 숫자에 범위(1~45)를 벗어난 숫자가 있습니다."),
    MONEY_ERROR("1000 단위의 금액을 입력하세요."),
    WIN_NUMBER_ERROR(",로 구분되는 로또번호 6개를 입력하세요."),
    BONUS_NUMBER_ERROR("당첨 번호에 포함되지 않는 로또 숫자 1개를 입력하세요.");

    public final String message;

    ErrorCode(String message) {
        this.message = message;
    }
}