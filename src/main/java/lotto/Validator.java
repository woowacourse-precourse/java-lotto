package lotto;

import java.util.List;

public class Validator {

    public void validDatePurchaseAmount(String purchaseAmount) {
        validDateType(purchaseAmount);
    }

    private void validDateType(String input) {
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주셔야 합니다.");
        }
    }
}
