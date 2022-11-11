package lotto;

import java.util.List;

public class Validator {

    public void validDatePurchaseAmount(String purchaseAmount) {
        validDateType(purchaseAmount);
        validDateThousandUnitNumber(Integer.parseInt(purchaseAmount));
    }

    private void validDateType(String input) {
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주셔야 합니다.");
        }
    }
    private void validDateThousandUnitNumber(Integer purchase) {
        if (purchase % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 숫자를 입력하셔야 합니다.");
        }
    }
}
