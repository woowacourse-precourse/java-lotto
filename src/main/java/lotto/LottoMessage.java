package lotto;

public enum LottoMessage {
    LOTTO_LENGTH_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    LOTTO_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_DUPLICATE_ERROR("[ERROR] 로또 번호는 중복되어선 안됩니다."),
    LOTTO_INPUT_ERROR("[ERROR] 로또 번호 입력 시, 숫자와 쉼표만 입력해야 합니다.");

    private String errorMessage;

    LottoMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
