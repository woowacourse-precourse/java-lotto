package service;

public enum Error {
    PURCHASE_AMOUNT_FORMAT("[ERROR] 구입 금액은 숫자만 입력해야 합니다."),
    PURCHASE_AMOUNT_VALUE("[ERROR] 구입 금액은 1,000원 단위만 입력해야 합니다."),
    WINNING_NUMBERS_FORMAT("[ERROR] 1~45 사이 번호 6개를 콤마와 공백 없이 입력해야 합니다. (e.g. 1,2,3,4,5,6)");

    private final String errorText;

    Error(String errorText) {
        this.errorText = errorText;
    }

    public String getText() {
        return this.errorText;
    }
}
