package lotto;

public enum ErrorMessage {
    INPUT_IS_NOT_DIGIT_ERROR("[ERROR] 입력 값이 정수가 아닙니다."),
    INPUT_IS_NOT_MULTIPLE_THOUSAND("[ERROR] 입력 값이 1000으로 나누어떨어지지 않습니다.");

    private final String message;

    ErrorMessage(String message){
        this.message=message;
    }

    public String print(){
        return message;
    }
}
