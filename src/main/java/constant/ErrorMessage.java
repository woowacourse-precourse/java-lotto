package constant;

public enum ErrorMessage {


    ERROR_NOT_NUMBER("[ERROR] 숫자가 아닌 것이 입력되었습니다"),
    ERROR_INCORRECT_MONEY("[ERROR] 올바르지 못한 입력 금액입니다.");

   private String message;

    private ErrorMessage(String message) {
        this.message=message;
    }


    public String getMessage() {
        return message;
    }
}
