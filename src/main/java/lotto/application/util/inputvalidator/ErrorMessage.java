package lotto.application.util.inputvalidator;

public enum ErrorMessage {
    PURCHASE_MONEY_IS_INTEGER("[ERROR] 구매 금액은 정수형으로, 입력 범위는 최대 2,147,483,647 까지 입니다."),
    PURCHASE_MONEY_DIVIDABLE("[ERROR] 구매 금액은 1000으로 나누어 떨어지는 단위만 가능합니다."),
    WINNING_NUMBERS_ARE_INTEGER("[ERROR] 로또 당첨 번호는 \"1,2,3,...\" 으로 입력받는 정수형이여야 합니다."),
    WINNING_NUMBERS_ARE_OVERLAPPED("[ERROR] 로또 당첨 번호는 중복될 수 없습니다."),
    WINNING_NUMBERS_LENGTH_IS_SIX("[ERROR] 보너스 숫자를 포함하지 않은 로또 당첨 번호 갯수는 6개입니다."),
    WINNING_NUMBERS_ARE_NUMERIC("[ERROR] 로또 당첨 번호는 \",\"를 구분자로 하는 6개의 정수만을 허용합니다."),
    WINNING_NUMBERS_RANGE("[ERROR] 로또 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_IS_OVERLAPPED("[ERROR] 중복된 보너스 번호입니다."),
    BONUS_NUMBER_IS_INTEGER("[ERROR] 보너스 로또 번호는 단 하나의 정수형을 입력하셔야 합니다."),
    BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    ;

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
