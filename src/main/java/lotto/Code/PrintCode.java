package lotto.Code;

public enum PrintCode {

    GET_MONEY("구입금액을 입력해 주세요.");

    private String message;

    private PrintCode(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
