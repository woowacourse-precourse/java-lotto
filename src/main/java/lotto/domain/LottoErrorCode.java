package lotto.domain;

public enum LottoErrorCode {
    INVALID_MONEY("로또 구입 금액은 1,000원 단위의 숫자로만 입력해야 합니다.");

    private final String ERROR_DESCRIPTION;

    LottoErrorCode(String errorDescription) {
        this.ERROR_DESCRIPTION = errorDescription;
    }

    @Override
    public String toString() {
        return "[ERROR] " + ERROR_DESCRIPTION;
    }

}
