package lotto;

public enum Error {
    NOT_NUMBER("[ERROR] 입력 금액은 숫자로만 이루어져야 합니다."),
    NOT_RIGHT_FORMAT("[ERROR] 입력 금액은 1000원 단위로 입력해야 합니다."),
    NOT_IN_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_RIGHT_COUNT("[ERROR] 당첨 번호는 6개이어야 합니다."),
    ;

    private final String label;

    Error(String label) {
        this.label = label;
    }

    public String lable() {
        return label;
    }
}
