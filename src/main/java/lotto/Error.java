package lotto;

public enum Error {

    INVALID_PRICE("[ERROR] 구입 금액은 1000원 단위의 숫자입니다.");

    private String message;
    Error(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
