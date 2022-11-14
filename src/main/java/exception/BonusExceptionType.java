package exception;

public enum BonusExceptionType {
    NOT_MATCH_BONUS_CNT("[ERROR] 보너스 번호의 개수가 1개가 아닙니다."),
    NOT_MATCH_BONUS_RANGE("[ERROR] 보너스 번호 범위가 1~45 사이가 아닙니다."),
    NOT_NUMBER_BONUS("[ERROR] 보너스 번호가 숫자가 아닙니다.");

    private String errorMessage;

    BonusExceptionType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
