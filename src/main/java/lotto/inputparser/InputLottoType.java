package lotto.inputparser;

/**
 * 일반 로또 번호에 해당하는 로또 문자열을 파싱하는 과정의 결과를 나타내는 enum 클래스입니다.
 * 파싱 결과와 에러 메시지를 포함합니다.
 */
public enum InputLottoType {
    /**
     * 정상적으로 파싱되었음을 의미합니다.
     */
    OK(""),
    /**
     * ,과 숫자로만 이루어지지 않은 비정상적인 문자열임을 의미합니다.
     */
    IS_NOT_NUMBER(",과 숫자로만 이루어져있어야 합니다."),
    /**
     * 6개의 숫자로 이루어지지 않은 비정상적인 문자열을 의미합니다.
     */
    IS_NOT_SIX_NUMBERS("6개의 숫자로 이루어져 있어야 합니다."),
    /**
     * 1~45의 범위를 벗어나는 비정상적인 문자열을 의미합니다.
     */
    OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    /**
     * 중복된 숫자를 포함한 비정상적인 문자열을 의미합니다.
     */
    DUPLICATED_NUMBER("중복된 숫자를 입력할 수 없습니다."),
    /**
     * 구입 금액 입력시 비정상적인 금액을 입력했음을 의미합니다.
     */
    INVALID_PURCHASE_AMOUNT("유효하지 않은 구입금액입니다."),
    /**
     * 구입 금액 입력시 숫자를 입력하지 않았음을 의미합니다.
     */
    IS_NOT_PURCHASE_NUMBER("숫자를 입력해야 합니다."),
    /**
     * 보너스 번호 입력 시 숫자를 입력하지 않았음을 의미합니다.
     */
    IS_NOT_BONUS_NUMBER("숫자를 입력해야 합니다.")
    ;

    private final String errorMessage;

    InputLottoType(String message) {
        this.errorMessage = message;
    }

    public String getMessage() {
        return errorMessage;
    }
}
