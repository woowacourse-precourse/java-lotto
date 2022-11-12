package lotto;

public enum Error {
    LENGTH_OVER_SIX("[ERROR] 6개의 숫자를 입력해주세요."),
    DUPLICATED("[ERROR] 중복된 수는 입력할수 없습니다."),
    RANGE_ERROR("[ERROR] 제시된 범위의 숫자만 입력 가능합니다."),
    IS_NOT_THOUSANDS("[ERROR] 천 단위의 숫자만 입력 가능합니다."),
    IS_NOT_NUMBER("[ERROR] 숫자만 입력 가능합니다.");

    private final String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
