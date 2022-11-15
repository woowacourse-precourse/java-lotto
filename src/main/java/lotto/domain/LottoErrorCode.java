package lotto.domain;

public enum LottoErrorCode {
    INVALID_MONEY("로또 구입 금액은 1,000원 단위의 숫자로만 입력해야 합니다."),
    INVALID_LOTTO_SIZE("로또 번호는 6개의 숫자여야 합니다."),
    INVALID_LOTTO_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다.");

    private final String ERROR_DESCRIPTION;

    LottoErrorCode(String errorDescription) {
        this.ERROR_DESCRIPTION = errorDescription;
    }

    @Override
    public String toString() {
        return "[ERROR] " + ERROR_DESCRIPTION;
    }

}
