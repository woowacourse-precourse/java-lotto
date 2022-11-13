package lotto.model;

public class Validator {
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INPUT_VALUE_IS_NOT_NUMBER = "입력은 숫자 형식이어야 합니다.";
    public static final String VALUE_IS_NOT_DIVIDED_BY_1000 = "구입 금액은 1,000원 단위로 입력해야 합니다.";

    public int convertStringIntoInt(String stringNumber) {
        int intNumber;
        try {
            intNumber = Integer.parseInt(stringNumber);
            return intNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_PREFIX + INPUT_VALUE_IS_NOT_NUMBER);
        }
    }

    public boolean isPurchaseAmountValidate(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + VALUE_IS_NOT_DIVIDED_BY_1000);
        }
        return true;
    }
}
