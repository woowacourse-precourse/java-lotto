package lotto;

import java.util.List;

public class Validator {

    public void validDatePurchaseAmount(String purchaseAmount) {
        validDateType(purchaseAmount);
        validDateThousandUnitNumber(Integer.parseInt(purchaseAmount));
        validRangeNumber(Integer.parseInt(purchaseAmount));
    }

    public void validDateBonusNumber(String bonusNumber) {
        validDateType(bonusNumber);
        validRangeLottoNumber(Integer.parseInt(bonusNumber));
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
    private void validRangeNumber(Integer purchase) {
        if (! (1000 <= purchase && purchase <= 100000)) {
            throw new IllegalArgumentException("[ERROR] 로또는 최대 100,000원까지 구매하실 수 있습니다.");
        }
    }
    private void validRangeLottoNumber(Integer number) {
        if (!(1 <= number && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 1이상 45 이하이 숫자를 입력하셔야 합니다.");
        }
    }
}
