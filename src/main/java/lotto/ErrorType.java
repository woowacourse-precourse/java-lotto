package lotto;

public enum ErrorType {
    MAKE_LOTTO_ERROR("making lotto is wrong"),
    INPUT_MONEY_ERROR("Input money is wrong"),
    INPUT_WINNING_NUMBER_ERROR("Input winning numbers are wrong"),
    INPUT_BONUS_NUMBER_ERROR("Input bonus number is wrong");

    private static final String ERROR_MESSAGE = "[ERROR]";
    private final String message;

    ErrorType(String message){
        this.message = message;
    }

    public String getMessage(){
        return ERROR_MESSAGE + " " +this.message;
    }
}
