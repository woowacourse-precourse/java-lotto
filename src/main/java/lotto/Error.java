package lotto;

public enum Error {

    NOT_NUMERIC("[ERROR] 숫자 형식이어야 합니다."),
    NOT_IN_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_DIVIDABLE("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다."),
    IS_NULL("[ERROR] 값을 입력해주세요."),
    OUT_OF_WINNING_FORMAT("[ERROR] 당첨 번호는 쉼표(,)로 구분되는 여섯 개의 숫자여야 합니다."),
    DUPLICATE_IN_WINNING("[ERROR] 당첨 번호는 중복되지 않은 숫자로 이루어져야 합니다."),
    DUPLICATE_IN_BONUS("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
