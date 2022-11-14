package lotto.domain;

public enum CustomException {
    RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    VALIDATE("로또 번호를 6개 입력해주세요."),
    DUPLICATE("중복된 로또 번호가 있습니다.");

    private String message;

    CustomException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
