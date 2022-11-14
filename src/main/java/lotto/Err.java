package lotto;

public enum Err {
    NUMERIC_ERROR           ("Lotto can only be numeric values"),
    PAYMENT_NUMBER_ERROR    ("Lotto payment can only be multiple of 1000"),
    LOTTO_FORMAT_ERROR("Lotto numbers can only be 6 comma-separated numbers"),
    RANGE_ERROR             ("Lotto should be in range [1, 45]"),
    DUPLICATE_ERROR         ("Lotto can not have duplicates");

    private static final String ERROR_MESSAGE  = "[ERROR] ";
    private final String msg;
    Err(String msg) {
        this.msg = msg;
    }

    public void invalid() {
        throw new IllegalArgumentException(ERROR_MESSAGE + msg);
    }
}
