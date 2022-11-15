package lotto.domain.enums;

public enum ExceptionMessage {
    NOT_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_NUMBER_SIZE("[ERROR] 로또 번호 는 6개 입니다."),
    DUPLICATE_NUMBER("[ERROR] 중복된 숫자가 존재합니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}
