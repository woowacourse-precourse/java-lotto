package constant;

public enum ErrorMessage {


    ERROR_NOT_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_INCORRECT_MONEY("[ERROR] 올바르지 못한 입력 금액입니다."),
    ERROR_INCORRECT_SIZE("[ERROR] 입력된 갯수가 올바르지 않습니다!"),
    ERROR_DUPLICATE("[ERROR] 중복된 숫자 발견!"),
    ERROR_OVERRANGE("[ERROR] 입력 범위 초과!"),

    ERROR_BONUS_OVERRANGE("[ERROR] 보너스 번호 입력 범위 초과!"),
    ERROR_BONUS_NOTNUMBER("[ERROR] 보너스 번호에는 숫자가 와야 합니다."),
    ERROR_BONUS_DUPLICATE_WINNING("[ERROR] 보너스 번호는 당첨번호와 겹쳐질 수 없습니다.");




   private String message;

    private ErrorMessage(String message) {
        this.message=message;
    }


    public String getMessage() {
        return message;
    }
}
