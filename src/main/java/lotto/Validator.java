package lotto;

public class Validator {

    private static final String ERROR = "[ERROR] ";
    private static final String INVALID_WINNING_NUMBER_LENGTH_ERROR = "당첨 번호는 6개의 숫자만 입력 가능합니다.";
    private static final String NEGATIVE_PRICE_ERROR = "음수인 금액은 입력할 수 없습니다.";
    private static final String NOT_INTEGER_ERROR = "정수가 아닌 문자열이 입력되었습니다.";
    private static final int WINNING_NUMBER_COUNT = 6;

    public static void validateNegativePrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException(ERROR + NEGATIVE_PRICE_ERROR);
        }
    }

    public static void validateWinningNumberInput(String[] winningNumbers) {
        if (winningNumbers.length != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR + INVALID_WINNING_NUMBER_LENGTH_ERROR);
        }
    }

    public static void validateInteger(String input) {
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ERROR + NOT_INTEGER_ERROR);
        }
    }

}
