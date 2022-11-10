package constant;

public enum ErrorMessage {


    ERROR_NOT_NUMBER("[ERROR] 숫자가 아닌 것이 입력되었습니다"),
    ERROR_INCORRECT_MONEY("[ERROR] 올바르지 못한 입력 금액입니다."),
    ERROR_LOTTO_OUTINDEX("[ERROR] 입력된 갯수 초과!"),
    ERROR_LOTTO_DUPLICATE("[ERROR] 중복된 숫자 발견!"),
    ERROR_LOTTO_OVERRANGE("[ERROR] 입력 범위 초과!"),
    ERROR_BONUS_OVERRANGE("[ERROR] 보너스 번호 입력 범위 초과!"),
    ERROR_BONUS_NOTNUMBER("[ERROR] 보너스 번호에는 숫자가 와야 합니다.");




   private String message;

    private ErrorMessage(String message) {
        this.message=message;
    }


    public String getMessage() {
        return message;
    }
}
