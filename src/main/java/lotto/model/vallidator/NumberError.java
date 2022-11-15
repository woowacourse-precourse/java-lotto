package lotto.model.vallidator;

public enum NumberError {
    PREFIX("[ERROR] "),
    NUMBER(PREFIX.message() + "숫자만 입력해야 합니다.")
    ;
    private final String message;
    NumberError(String message) {
        this.message = message;
    }
    public String message() {
        return message;
    }
}
