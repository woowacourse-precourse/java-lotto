package exception;

public enum LottoExceptionType {
    NOT_MATCH_CNT("로또 숫자 개수가 6개가 아닙니다."),
    NOT_MATCH_RANGE("로또 숫자 범위가 1~45 사이가 아닙니다."),
    NOT_UNIQUE_NUMBER("로또 숫자가 중복되었습니다.");

    private String errorMessage;

    LottoExceptionType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
