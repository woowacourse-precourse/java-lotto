package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INPUT_VALUE_IS_NOT_NUMBER = "입력은 숫자 형식이어야 합니다.";
    public static final String PURCHASE_AMOUNT_IS_NOT_DIVIDED_BY_1000 = "구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String WINNING_NUMBER_INPUT_IS_INVALID_INPUT_TYPE = "입력은 쉼표(,)를 기준으로 한 숫자 형식이어야 합니다.";
    private static final String WINNING_NUMBER_IS_NOT_SIX = "당첨 번호가 6개보다 많거나 적은 수의 번호를 가지고 있습니다. 당첨 번호는 6개만 입력해야 합니다.";
    private static final String WINNING_NUMBER_IS_NOT_BETWEEN_1_AND_45 = "당첨 번호 중 1에서 45의 범위를 벗어난 번호가 있습니다. 당첨 번호는 1~45 사이의 숫자만 입력이 가능합니다.";
    private static final int PRICE_OF_LOTTO = 1000;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int CORRECT_WINNING_NUMBER_SIZE = 6;

    public int convertStringIntoInt(String input) {
        try {
            int result = Integer.parseInt(input);
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_PREFIX + INPUT_VALUE_IS_NOT_NUMBER);
        }
    }

    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + PURCHASE_AMOUNT_IS_NOT_DIVIDED_BY_1000);
        }
    }

    public List<Integer> convertStringIntoList(String input) {
        try {
            List<Integer> result = List.of(input.split(",")).stream()
                    .map(x -> Integer.parseInt(x))
                    .collect(Collectors.toList());
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_PREFIX + WINNING_NUMBER_INPUT_IS_INVALID_INPUT_TYPE);
        }
    }

    public void validateWinningNumber(List<Integer> winningNumber) {
        validateSizeOfWinningNumber(winningNumber);
        validateWinningNumberBetween1And45(winningNumber);
    }

    private void validateSizeOfWinningNumber(List<Integer> winningNumber) {
        if (winningNumber.size() != CORRECT_WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_PREFIX + WINNING_NUMBER_IS_NOT_SIX);
        }
    }

    private void validateWinningNumberBetween1And45(List<Integer> winningNumber) {
        List<Integer> filter_numbers = winningNumber.stream()
                .filter(number -> number < START_NUMBER || number > END_NUMBER)
                .collect(Collectors.toList());
        if (!filter_numbers.isEmpty()) {
            throw new IllegalArgumentException(ERROR_PREFIX + WINNING_NUMBER_IS_NOT_BETWEEN_1_AND_45);
        }
    }
}
