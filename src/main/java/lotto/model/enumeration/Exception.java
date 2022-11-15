package lotto.model.enumeration;

public enum Exception {

    PREFIX("\n[ERROR] "),
    INVALID_INPUT_ONLY_NUMBER("숫자만을 입력해야 합니다."),
    INVALID_LOTTO_NUMBER_COUNT("로또 번호는 6개이어야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("로또 번호의 숫자 범위는 1부터 45까지입니다."),
    INVALID_LOTTO_NUMBER_DUPLICATION("로또 번호는 서로 중복될 수 없습니다."),
    INVALID_BONUS_NUMBER_DUPLICATION("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_BONUS_NUMBER_RANGE("보너스 번호의 숫자 범위는 1부터 45까지입니다."),
    INVALID_PURCHASE("로또 구입 금액은 1000원 단위이어야 합니다.");

    private final String exceptionMessage;

    Exception(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
