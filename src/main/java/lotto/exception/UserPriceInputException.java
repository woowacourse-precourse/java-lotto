package lotto.exception;

public class UserPriceInputException {

    private static final String PERMIT_NUM = "[0-9]+";

    public void isUserPriceValid(String userPrice) {
        isContainedOnlyNumber(userPrice);
        isUserPriceDivideByThousand(Integer.valueOf(userPrice));
    }

    public void isContainedOnlyNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!isUserInputContainsOnlyNumber(input)) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 양의 숫자로만 입력되어야 합니다.");
            }
        }
    }

    private void isUserPriceDivideByThousand(Integer userPrice) {
        if (userPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public boolean isUserInputContainsOnlyNumber(String input) {
        if (input.matches(PERMIT_NUM)) {
            return true;
        }
        return false;
    }
}
