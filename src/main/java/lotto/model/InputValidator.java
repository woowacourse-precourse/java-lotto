package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INPUT_VALUE_IS_NOT_NUMBER = "입력은 숫자 형식이어야 합니다.";
    public static final String VALUE_IS_NOT_DIVIDED_BY_1000 = "구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String INPUT_VALUE_IS_INVALID_INPUT_TYPE = "입력은 쉼표(,)를 기준으로 한 숫자 형식이어야 합니다.";
    private static final int PRICE_OF_LOTTO = 1000;

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
            throw new IllegalArgumentException(ERROR_PREFIX + VALUE_IS_NOT_DIVIDED_BY_1000);
        }
    }

    public List<Integer> convertStringIntoList(String input) {
        try {
            List<Integer> result = List.of(input.split(",")).stream()
                    .map(x -> Integer.parseInt(x))
                    .collect(Collectors.toList());
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_PREFIX + INPUT_VALUE_IS_INVALID_INPUT_TYPE);
        }
    }
}
