package lotto.util;

public enum SystemErrorMessage {
    MONEY_ERROR("[ERROR] 1000으로 나누어 떨어지는 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE_WIN_NUMBER("[ERROR] 당첨 번호와 보너스 번호가 일치 합니다."),
    NUMBER_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    private String errorMessage;

    SystemErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
