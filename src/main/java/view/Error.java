package view;

public enum Error {
    ERROR_NOT_NUMBER("[ERROR] 숫자만 입력해주세요."),
    ERROR_LACK_NUMBER("[ERROR] 로또 번호가 부족합니다."),
    ERROR_OVERLAP_NUMBER("[ERROR] 로또 번호가 중복되었습니다."),
    ERROR_RangeOver("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_AMOUNT_IS_NOT_RIGHT("[ERROR] 금액은 1,000원 단위로 떨어져야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
