package lotto;

public enum ErrorCode {
    OUT_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String value;

    ErrorCode(String value) { this.value = value; }
    public String getValue() { return value; }
    public String getErrorMessage() { return "[Error] " + value; }
}
