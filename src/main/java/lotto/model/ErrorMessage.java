package lotto.model;

public enum ErrorMessage {
    NOT_STRING_ERROR_MESSAGE("[ERROR] 로또 금액은 숫자여야 합니다."),
    NOT_DIVIDED_BY_THOUSAND_ERROR_MESSAGE("[ERROR] 1000원으로 나누어 떨어져야 합니다.");

    private final String message;

    ErrorMessage (String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
