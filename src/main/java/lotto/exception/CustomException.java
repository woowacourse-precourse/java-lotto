package lotto.exception;

public enum CustomException {
    RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    VALIDATE("로또 번호를 6개 입력해주세요."),
    DUPLICATE("중복된 로또 번호가 있습니다."),
    HAVEREST("1000원 단위로 입력 해주세요.");

    private String message;

    CustomException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
