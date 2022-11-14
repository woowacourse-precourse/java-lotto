package exception;

public enum WinningExceptionType {
    NOT_MATCH_NUMBER_COUNT("[ERROR] 당첨 번호의 숫자 개수는 6개여야 합니다."),
    NOT_MATCH_NUMBER_RANGE("[ERROR] 당첨 번호의 숫자는 1이상 45이하여야 합니다."),
    NOT_UNIQUE_NUMBER("[ERROR] 당첨 번호는 중복이 되면 안됩니다."),
    NOT_MATCH_IS_NUMBER("[ERROR] 당첨 번호는 숫자여야 합니다."),
    NOT_MATCH_COMMA("[ERROR] 입력은 ,로 구분해야 합니다.");

    private String errorMessage;

    WinningExceptionType(String errorMessage){
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage() {
        return errorMessage;
    }

}
