package lotto;

public enum Error {

    INVALID_LIST("[ERROR] 6개의 숫자를 입력하세요."),
    INVALID_PRICE("[ERROR] 구입 금액은 1000원 단위의 숫자입니다."),
    INVALID_INPUT_VALUE("[ERROR] 각 번호는 1~45 사이의 숫자여야 합니다."),
    INPUT_DUPLICATE("[ERROR] 중복된 숫자가 존재합니다.");

    private final String message;
    Error(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
