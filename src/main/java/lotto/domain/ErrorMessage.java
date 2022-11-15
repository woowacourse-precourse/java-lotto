package lotto.domain;

public enum ErrorMessage {
    INPUT_IS_NOT_DIGIT_ERROR("[ERROR] 입력 값이 정수가 아닙니다."),
    INPUT_IS_NOT_MULTIPLE_THOUSAND_ERROR("[ERROR] 입력 값이 1000으로 나누어떨어지지 않습니다."),
    INPUT_LOTTO_NUMBERS_NOT_NUMERIC("[ERROR] 당첨 로또 번호는 정수여야 합니다."),
    INPUT_LOTTO_NUMBERS_CONTAIN_BLANK("[ERROR] 공백 없이 입력해야 합니다."),
    LOTTO_SIZE_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    BONUS_NUMBER_DUPLICATION_ERROR("[ERROR] 보너스 번호는 중복되면 안됩니다."),
    LOTTO_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_DUPLICATE_ERROR("[ERROR] 로또 번호에는 중복이 없어야 합니다.");

    private final String message;

    ErrorMessage(String message){
        this.message=message;
    }

    public String print(){
        return message;
    }
}
