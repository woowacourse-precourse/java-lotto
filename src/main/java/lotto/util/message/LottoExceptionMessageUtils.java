package lotto.util.message;

public enum LottoExceptionMessageUtils {

    INVALID_NUMBER_FORMAT("%s 입력한 값을 숫자로 치환할 수 없습니다. 입력 값 : %s"),
    INVALID_NUMBER_RANGE("%s 로또 번호는 1부터 45 사이의 숫자여야 합니다. 입력 값 : %s"),
    INVALID_NUMBER_SIZE("%s 유효한 숫자는 총 6개여야만 합니다. 유효 숫자 개수 : %d"),
    INVALID_PURCHASE_AMOUNT_UNIT("%s 구입 금액은 1000원 단위여야만 합니다. 입력 금액 : %s"),
    INVALID_SEPARATOR("%s 필요한 숫자 구분자(,)가 누락되었습니다. 입력 값 : %s"),
    INVALID_NUMBER_LENGTH("%s 유효하지 않은 길이입니다. 입력 값 길이 : %s"),
    INVALID_RANKING("%s 존재하지 않는 등수입니다. 입력 값 : %s");

    private final String message;

    LottoExceptionMessageUtils(String message) {
        this.message = message;
    }

    public String findExceptionMessage(Object target) {
        return String.format(this.message, CommonMessageConst.EXCEPTION_MESSAGE_PREFIX, target);
    }
}
