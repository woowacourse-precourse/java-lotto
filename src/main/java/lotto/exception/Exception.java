package lotto.exception;

public enum Exception {
    NOT_SIX_NUMBER ("[ERROR] 숫자 6개를 입력하세요."),
    NOT_COMMA_INPUT("[ERROR] 쉼표로 숫자를 구분하여 입력하세요."),
    NOT_NUMBER("[ERROR] 숫자만 입력하세요."),
    WRONG_UNIT("[ERROR] 1,000원 단위로 입력하세요."),
    WRONG_RANGE("[ERROR] 1 ~ 45 사이의 숫자만 입력하세요."),
    DUPLICATE_NUMBER("[ERROR] 중복된 값은 입력할 수 없습니다.");

    private final String exceptionMessage;

    Exception(String exceptionMessage){
        this.exceptionMessage = exceptionMessage;
    }
    public String getExceptionMessage(){
        return this.exceptionMessage;
    }

}