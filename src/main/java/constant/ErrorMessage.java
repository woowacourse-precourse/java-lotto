package constant;

public enum ErrorMessage {


    ERROR_INCORRECT_MONEY("[ERROR] 올바르지 못한 금액이 입력되었습니다."),
    ERROR_INCORRECT_SIZE("[ERROR] 입력된 갯수가 올바르지 않습니다!"),
    ERROR_WINNING_DUPLICATE("[ERROR] 당첨 번호에 중복된 숫자가 올 수 없습니다!"),

    ERROR_NO_MONEY("[ERROR] 로또를 구매하지 않으셨습니다."),

    ERROR_INCORRECT_CURRENCY("[ERROR] 금액 단위는 1000원 단위입니다!"),
    ERROR_WINNING_OVERRANGE("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다!"),
    ERROR_WINNING_NOT_NUMBER("[ERROR] 당첨 번호에는 문자가 올 수 없습니다!"),

    ERROR_BONUS_OVERRANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다!"),
    ERROR_BONUS_NOT_NUMBER("[ERROR] 보너스 번호에는 숫자가 와야 합니다."),
    ERROR_BONUS_DUPLICATE_WINNING("[ERROR] 보너스 번호는 당첨번호와 겹쳐질 수 없습니다.");


    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
