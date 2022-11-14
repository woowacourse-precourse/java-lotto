package lotto;

public enum ErrorType {
    NOT_NUMBER("숫자만 입력해주세요"),
    DUPLICATE("중복되지 않은 번호를 입력해주세요."),
    RANGE("1~45 사이의 숫자를 입력해주세요"),
    SIZE("로또 번호는 6개로 이루어져 있습니다."),
    PRICE("1000원 단위로 입력해주세요");

    private final String message;

    ErrorType(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
