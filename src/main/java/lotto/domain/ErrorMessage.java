package lotto.domain;

public enum ErrorMessage {

    COMMON_MESSAGE("[ERROR] "),
    LOTTE_SIZE_INVALID("Lotto Number Length Is Incorrect. SIZE : "),
    LOTTE_NUMBER_DUPLICATION("Lotto Number Have Duplicate Number."),
    LOTTE_NUMBER_OUT_BOUND("Lotto Number Have Out Bound Number."),
    LOTTE_NUMBER_NOT_ASC("Lotto Number Not Sorted by ASC."),
    PURCHASE_PAY_CONSISTENCE("Purchase Pay Isn't Consist Of Number."),
    PURCHASE_PAY_REMINDER("Purchase Pay Reminder Isn't Zero.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
