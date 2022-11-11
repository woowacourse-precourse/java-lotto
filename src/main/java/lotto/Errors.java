package lotto;

public enum Errors {
    NOT_DIVIDE_BY_1000("구매 금액은 천 단위로 입력해야 합니다."),
    NOT_INCLUDE_CHARACTER("문자가 포함될 수 없습니다."),
    OUT_OF_RANGE("로또 번호는 숫자는 1부터 45 사이의 숫자여야 합니다."),
    NOT_DUPLICATE_NUMBER("로또 번호는 중복된 숫자가 포함될 수 없습니다."),
    NOT_SIX_NUMBERS("로또 번호는 6개의 숫자로 구성되어야 합니다.");

    private final String message;

    Errors(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR] " + this.message;
    }
}
