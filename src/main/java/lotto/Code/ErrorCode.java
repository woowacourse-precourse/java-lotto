package lotto.Code;

public enum ErrorCode {

    NO_DIVIDE_BY_1000("[ERROR] 지불 가능한 금액은 1000원 단위입니다."),
    LENGTH_MUST_BE_SIX("[ERROR] 당첨 번호는 여섯자리입니다.");

    private String message;

    private ErrorCode(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
