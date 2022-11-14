package lotto;

public enum ErrorMessage {
    NOT_COAST("[ERROR] 1000원 단위로 구매해주세요."),
    LESS_COAST("[ERROR] 1000원 이상의 금액을 입력하세요."),
    LESS_SIZE_NUMBER("[ERROR] 번호 6개를 입력하세요."),
    NOT_DIGIT("[ERROR] 숫자만 입력하세요."),
    CONTAIN_WINNING_NUMBER("[ERROR] 당첨번호와 겹치지 않는 숫자를 입력하세요."),
    DUPLICATED_NUMBER("[ERROR] 중복된 숫자가 있습니다."),
    NOT_NUMBER_RANGE("[ERROR] 1 ~ 45 사이의 숫자를 입력하세요.");

    ErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
    private final String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }
}
