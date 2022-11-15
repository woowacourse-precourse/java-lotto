package lotto.domain.validator;

public enum ErrorMessages {
    INPUT_ERROR_MESSAGE("[ERROR] 오직 숫자들만 쉼표로 공백없이 구분해 입력해야 합니다"),
    NEMERIC_ERROR_MESSAGE("[ERROR] 입력된 값이 숫자가 아닙니다"),
    RANGE_ERROR_MESSAGE("[ERROR] %d ~ %d 사이의 숫자들로 입력해야 합니다"),
    DUPLICATE_ERROR_MESSAGE("[ERROR] 당첨번호들 중 중복되는 값이 있습니다"),
    DIVIDED_ERROR_MESSAGE("[ERROR] 입력된 값이 %d원 단위가 아닙니다"),
    SIZE_ERROR_MESSAGE("[ERROR] 숫자들이 %d개로 구성돼야 합니다");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
