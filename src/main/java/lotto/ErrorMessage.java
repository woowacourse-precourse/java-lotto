package lotto;

public enum ErrorMessage {
    PURCHASE_MONEY_IS_INTEGER("[ERROR] 금액(숫자)을 입력하세요"),
    PURCHASE_MONEY_DIVIDABLE("[ERROR] 구매 금액은 1000으로 나누어 떨어지는 단위만 가능합니다."),
    WINNING_NUMBERS_ARE_DUPLICATED("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    WINNING_NUMBERS_LENGTH_IS_SIX("[ERROR] 보너스 숫자를 포함하지 않은 로또 당첨 번호 갯수는 6개입니다."),
    WINNING_NUMBERS_RANGE("[ERROR] 로또 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_IS_DUPLICATED("[ERROR] 보너스 번호는 로또 번호와 중복되지 않아야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMsg() {
        return message;
    }
}
