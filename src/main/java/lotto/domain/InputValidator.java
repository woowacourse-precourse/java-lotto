package lotto.domain;

public class InputValidator {

    public static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주어야 합니다.";
    public static final String NOT_ENOUGH_MONEY_ERROR_MESSAGE = "[ERROR] 로또를 사기 충분한 돈을 입력해 주세요 ( " + Lotto.PRICE + "원 이상)";
    public static final String NOT_DIVIDED_WITH_LOTTO_PRICE_ERROR_MESSAGE = "[ERROR] 로또 가격 ( " + Lotto.PRICE + "원) 으로 나누어 떨어지는 금액을 입력해주세요.";
    public static final String NUMBERS_INPUT_FORMAT_ERROR_MESSAGE = "[ERROR] 당첨 번호는 6자리의 숫자를 쉼표(,)로 구분하여 입력해 주세요.";

    private static final String NUMBER_REGEX = "^\\d+$";
    private static final String NUMBERS_INPUT_REGEX = "^\\d+(,\\d+){5}$";


    public static void validateIsNumber(String input) throws IllegalArgumentException {
        if (input.matches(NUMBER_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
    }

    public static void validateLottoPurchaseNumber(int purchaseAmount) throws IllegalArgumentException {
        if (purchaseAmount < Lotto.PRICE) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY_ERROR_MESSAGE);
        }
        if (purchaseAmount % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_WITH_LOTTO_PRICE_ERROR_MESSAGE);
        }
    }

    public static void validateWinningNumbersInput(String input) {
        if (input.matches(NUMBERS_INPUT_REGEX)) {
            return;
        }
        throw new IllegalArgumentException(NUMBERS_INPUT_FORMAT_ERROR_MESSAGE);
    }
}
