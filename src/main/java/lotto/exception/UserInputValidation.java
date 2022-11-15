package lotto.exception;


public class UserInputValidation {
    private static final int ASCII_ZERO = 48;
    private static final int ASCII_NINE = 57;
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final String DELIMITER = ",";
    private static final String ERROR_IS_NOT_NUMBER = "[ERROR] 숫자만 입력 해 주세요.";
    private static final String ERROR_CAN_NOT_BUY_LOTTO = "[ERROR] 1000원 단위로 입력 해주세요.";
    private static final String ERROR_IS_NOT_CORRECT_COUNT = "[ERROR] 당첨 번호는 서로 다른 숫자 6개 입니다.(구분자 \',\')";
    private static final String ERROR_IS_INVALID_NUMBER = "[ERROR] 1~45 사이의 숫자만 입력 해 주세요.";
    private static final String ERROR_ONLY_WHITE_SPACE = "[ERROR] 공백만 입력하면 안 됩니다. 숫자를 입력 해 주세요.";

    public UserInputValidation() {

    }

    public void checkIsNumber(String number) {
        for (int i = 0; i < number.length(); ++i) {
            if (number.charAt(i) < ASCII_ZERO || ASCII_NINE < number.charAt(i)) {
                throw new IllegalArgumentException(ERROR_IS_NOT_NUMBER);
            }
        }
    }

    public void checkBuyLotto(int amount) {
        if (amount % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(ERROR_CAN_NOT_BUY_LOTTO);
        }
    }

    public void checkCorrectCount(String userInput) {
        String[] winningNumbers = userInput.split(DELIMITER);
        if (winningNumbers.length != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_IS_NOT_CORRECT_COUNT);
        }
    }

    public void checkInvalidNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < number) {
            throw new IllegalArgumentException(ERROR_IS_INVALID_NUMBER);
        }
    }

    public void checkWhiteSpace(String input) {
        if (input.length() < ONE) {
            throw new IllegalArgumentException(ERROR_ONLY_WHITE_SPACE);
        }
    }
}
