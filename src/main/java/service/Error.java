package service;

public enum Error {
    PURCHASE_AMOUNT_FORMAT("[ERROR] 구입 금액은 숫자만 입력해야 합니다."),
    PURCHASE_AMOUNT_VALUE("[ERROR] 구입 금액은 1,000원 단위만 입력해야 합니다.");

    private final String errorText;

    Error(String errorText) {
        this.errorText = errorText;
    }

    public String getText() {
        return this.errorText;
    }
}
