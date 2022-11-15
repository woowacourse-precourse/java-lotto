package lotto.utils.constants;

public enum ErrorMessage {

    INVALID_LOTTO_COUNT("로또 번호는 6개이어야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호는 1이상 45이하의 숫자여야 합니다."),
    INVALID_LOTTO_DUPLICATION("로또 번호는 중복될 수 없습니다."),
    INVALID_LOTTO_TYPE("당첨 번호는 숫자만 입력이 가능합니다."),
    INVALID_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_PURCHASE_MONEY("구입금액은 숫자만 입력 가능합니다."),
    INVALID_PURCHASE_UNIT("구입금액은 1,000원 단위로 입력 가능합니다."),
    INVALID_PURCHASE_RANGE("구입 금액은 0이상" + Long.MAX_VALUE + "이하 입니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
