package lotto;

public enum Errors {
    NOT_DIVIDE_BY_1000("구매 금액은 천 단위로 입력해야 합니다."),
    NOT_INCLUDE_CHARACTER("문자가 포함될 수 없습니다.");

    private final String message;

    Errors(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR] " + this.message;
    }
}
