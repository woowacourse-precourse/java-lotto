package lotto;

public enum Error {

    PRICE_UNIT_ERROR("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");

    private String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
