package lotto.exception;

public enum Exception {
    NOT_DISIT("숫자가 아닙니다."),
    NOT_EFFECTIVE_UNIT("금액은 1000원 단위여야 합니다"),
    INVALID_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_NUMBER_COUNT("로또 번호의 개수는 6개여야 합니다."),
    DUPLICATED("중복된 숫자가 없어야 합니다.");

    private String errorMessage;

    Exception(String errorMessage) {
        this.errorMessage = "[ERROR]" + errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
