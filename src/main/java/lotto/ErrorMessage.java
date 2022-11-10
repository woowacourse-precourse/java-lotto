package lotto;

public enum ErrorMessage {
    INVALID_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_COUNT("[ERROR] 로또 번호는 총 6개의 숫자여야 합니다."),
    HAVE_DUPLICATED_NUMBER("[ERROR] 모든 번호는 중복되지 않아야 합니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
