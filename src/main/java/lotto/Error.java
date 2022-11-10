package lotto;

public enum Error {
    NOT_NUMBER_COUNT_SIX("[ERROR] 로또 번호는 6개의 숫자여야 합니다."),
    NOT_NUMBER_IN_BOUNDARY("[ERROR] 로또 번호는 1~45 사이 숫자여야 합니다."),
    NOT_NUMBER_DIVIDED_1000("[ERROR] 구입 금액은 1000원 단위입니다."),
    BONUS_DUPLICATE_LOTTO("[ERROR] 보너스 번호는 로또 번호와 중복되지 않은 숫자여야 합니다."),
    NUMBER_DUPLICATE("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다."),
    INPUT_IS_NOT_NUM("[ERROR] 구입 금액은 숫자여야 합니다.");

    private String errorMsg;

    Error(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
