package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInputNumber {

    private final int userPurchaseAmount;

    public UserInputNumber(String input) {
        validatePurchaseAmount(input);
    }
    private void validatePurchaseAmount(String input) {
        try {
            int p = Integer.parseint(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException ("숫자를 입력해주세요.");
        }
    }
}

