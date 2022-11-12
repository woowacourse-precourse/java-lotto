package lotto.resources;

public enum ErrorMessage {
    NOT_NUMBER_ERROR("입력된 금액이 숫자가 아닙니다."),
    ZERO_WON_ERROR("입력된 금액이 0원보다는 커야 합니다."),
    UNIT_ERROR("입력된 금액이 1000원 단위로 나눠 떨어져야 합니다."),
    SIZE_ERROR("입력된 숫자의 개수가 6개가 아닙니다."),
    DUPLICATE_ERROR("중복된 숫자가 존재합니다."),
    RANGE_ERROR("입력 숫자 범위를 벗어났습니다."),
    ALREADY_EXIST_ERROR("이미 당첨 번호에 있는 숫자 입니다.");

    private String errorMessage;
    private final String ERROR_PREFIX = "[ERROR] ";

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR_PREFIX + errorMessage;
    }
}
