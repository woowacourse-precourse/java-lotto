package lotto.domain;

public enum Message {
    Exception_NotCorrectSize("[ERROR] 6개의 숫자를 입력해주세요."),
    Exception_NotInteger("[ERROR] 숫자를 입력해주세요."),
    Exception_Not1000unit("[ERROR] 1000원 단위만 입력 가능합니다."),
    Exception_NegativeNum("[ERROR] 양수를 입력해주세요."),
    Exception_NotInRange("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    Exception_DuplicateNum("[ERROR] 중복되지 않는 숫자만 입력 가능합니다.");
    private String message;
    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
