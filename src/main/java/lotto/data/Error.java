package lotto.message;

public enum Error {
    OUT_OF_RANGE("복권 하나는 1000원입니다. 1000원 단위로 입력해주세요."),
    DUPLICATE_NUMBER("중복되지 않는 6자리 수를 입력해주세요."),
    INVALID_SIZE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    IS_NUMERIC("문자가 입력되었습니다. 1000원 단위의 금액을 입력해주세요."),
    DIVISIBLE_THOUSAND("복권 하나는 1000원입니다. 1000원 단위로 입력해주세요."),
    BONUS_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    ANOTHER_NUM("당첨 번호 6자리와 다른 수를 입력해주세요.");

    private final String message;

    Error(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
