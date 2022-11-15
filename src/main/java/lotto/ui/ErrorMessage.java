package lotto.ui;

public enum ErrorMessage {
    IllegalArgumentException("잘못 입력하였습니다");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    private  ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return PREFIX+message;
    }
}
