package lotto;

public class Validator {

    private static final String ERROR = "[ERROR] ";
    private static final String INVALID_WINNING_NUMBER_LENGTH_ERROR = "당첨 번호는 6개의 숫자만 입력 가능합니다.";
    private static final String NEGATIVE_PRICE_ERROR = "음수인 금액은 입력할 수 없습니다.";
    private static final String NOT_INTEGER_ERROR = "정수가 아닌 문자열이 입력되었습니다.";
    private static final String WRONG_INPUT_MONEY = "1_000원 단위 입력만 가능합니다.";
    private static final String MAX_INPUT_MONEY = "개인당 최대 구매 금액인 100_000원 입니다..";
    private static final int WINNING_NUMBER_COUNT = 6;


    //  음수입력 시 에러
    public static void validateNegativePrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException(ERROR + NEGATIVE_PRICE_ERROR);
        }
    }

    // 1000원 단위 입력
    public static void validateInputMoney(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ERROR + WRONG_INPUT_MONEY);
        }
    }

    // 10만원 구입 제한
    public static void validateMaxInputMoney(int price) {
        if (price > 100000) {
            throw new IllegalArgumentException(ERROR + MAX_INPUT_MONEY);
        }
    }

    // 당첨 금액 6자리로만 입력
    public static void validateWinningNumberInput(String[] winningNumbers) {
        if (winningNumbers.length != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR + INVALID_WINNING_NUMBER_LENGTH_ERROR);
        }
    }

    // 구입금액 숫자만 입력 가능
    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + NOT_INTEGER_ERROR);
        }
    }



}
