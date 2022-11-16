package lotto.domain;

public enum ExceptionMessage {

    PREFIX("[ERROR]"),
    NUMERIC(PREFIX.getMessage() + " 숫자만 입력 가능합니다."),
    LENGTH(PREFIX.getMessage() + " 로또 번호는 6개의 숫자여야 합니다."),
    PURCHASE_RANGE(PREFIX.getMessage() + "구입금액은 1000원 이상이어야 합니다."),
    DIVIDE(PREFIX.getMessage() + " 구입금액은 1000원으로 나누어 떨어져야 합니다."),
    LOTTO_NUMBER_RANGE(PREFIX.getMessage() + " 번호는 1부터 45사이의 숫자여야 합니다"),
    DUPLICATE_NUM_LOTTO(PREFIX.getMessage() + " 로또 번호에는 중복된 숫자가 있으면 안됩니다."),
    DUPLICATE_NUM_BONUS(PREFIX.getMessage() + "보너스 번호는 당첨 번호에 없는 숫자여야 합니다.");

    private final String message;
    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
