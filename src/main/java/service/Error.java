package service;

public enum Error {
    PURCHASE_AMOUNT_FORMAT("[ERROR] 구입 금액은 숫자만 입력해야 합니다."),
    PURCHASE_AMOUNT_VALUE("[ERROR] 구입 금액은 1,000원 단위만 입력해야 합니다."),
    WINNING_NUMBERS_FORMAT("[ERROR] 1부터 45 사이의 번호 6개를 콤마와 공백 없이 입력해야 합니다. (e.g. 1,2,3,4,5,6)"),
    WINNING_NUMBERS_INCLUDE_SAME_NUMBER("[ERROR] 6개의 번호 중 중복되는 번호가 존재합니다."),
    BONUS_NUMBER_FORMAT("[ERROR] 1부터 45 사이의 번호 1개만을 입력해야 합니다."),
    BONUS_NUMBER_IN_WINNING_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String errorText;

    Error(String errorText) {
        this.errorText = errorText;
    }

    public String getText() {
        return this.errorText;
    }
}
