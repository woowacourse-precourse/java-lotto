package lotto.error;

public enum ErrorMsg {
    WRONG_BUYING_UNIT("[ERROR] 로또의 구입 금액은 1,000원 단위입니다.");

    private final String errorMsg;

    ErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return errorMsg;
    }
}
