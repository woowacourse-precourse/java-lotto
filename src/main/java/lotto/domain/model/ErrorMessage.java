package lotto.domain.model;

public enum ErrorMessage {

    COMMON_MESSAGE("[ERROR] "),
    INPUT_NULL("You entered a null value."),
    BONUS_NUMBER_OUT_BOUND("Bonus Number Have Out Bound Number."),
    LOTTE_SIZE_INVALID("Lotto Number Length Is Incorrect. SIZE : "),
    LOTTE_NUMBER_DUPLICATION("Lotto Number Have Duplicate Number."),
    LOTTE_NUMBER_OUT_BOUND("Lotto Number Have Out Bound Number."),
    LOTTE_NUMBER_NOT_ASC("Lotto Number Not Sorted by ASC."),
    PURCHASE_PAY_CONSISTENCE("Purchase Pay Isn't Consist Of Number."),
    PURCHASE_PAY_REMINDER("Purchase Pay Reminder Isn't Zero."),
    NOT_DIVIDE_COMMAS("Please DIVIDE Number With Commas"),
    BONUS_NUMBER_DUPLICATION("Lotte Has A Duplicate Value With The Bonus Number."),
    BONUS_NUMBER_INVALID("Bonus Number Invalid");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String getErrorMessage(ErrorMessage errorMessage) {
        return COMMON_MESSAGE.getMessage() + errorMessage.getMessage();
    }
}
