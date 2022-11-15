package lotto;

public enum ErrorMessage {
    INPUT_IS_NOT_DIVIDIED_BY_1000_ERROR("[ERROR] 입력값은 1000 단위로 나누어 떨어지지 않습니다."),
    INPUT_IS_NOT_NUMBERS_ERROR("[ERROR] 입력값이 정수가 아닙니다."),
    INPUT_SEPARATORS_ARE_NOT_COMMAS_ERROR("[ERROR] 구분자가 쉼표여야 합니다."),
    LOTTO_NUMBER_IS_DUPLICATED("[ERROR] 로또 번호는 서로 중복되면 안됩니다."),
    BONUS_NUMBER_IS_DUPLICATED("[ERROR] 보너스 번호가 로또 번호와 중복되면 안됩니다."),
    LOTTO_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_SIZE_ERROR("[ERROR] 로또 번호는 6자리여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String print(){
        return message;
    }
}
