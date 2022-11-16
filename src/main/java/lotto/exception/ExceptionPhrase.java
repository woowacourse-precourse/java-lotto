package lotto.exception;

public enum ExceptionPhrase {

    EXCEPTION_DUPLICATE_NUMBER("[ERROR] 로또 번호에 중복된 숫자가 있습니다."),
    EXCEPTION_ONLY_SIX_NUMBER_CAN_BE_ENTERED("[ERROR] 숫자는 6개만 입력 가능합니다."),
    EXCEPTION_INVALID_MONEY_UNIT("[ERROR]1000원 단위로 입력해주세요"),
    EXCEPTION_INVALID_INPUT("[ERROR] 숫자만 입력 가능합니다."),
    EXCEPTION_OUT_OF_RANGE("[ERROR] 0 ~45 이하의 숫자만 입력 가능합니다."),
    EXCEPTION_BONUS_NUMBER_DUPLICATED("[ERROR] 보너스 숫자가 로또 번호와 중복됩니다."),
    EXCEPTION_INVALID_RESULT("[ERROR] 일치하는 숫자 개수는 6개 이하여야 합니다.");

    private String message;

    ExceptionPhrase(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
