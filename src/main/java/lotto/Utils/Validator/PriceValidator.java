package lotto.Utils.Validator;

import lotto.View.OutputView;

public class PriceValidator {
    public static void price(int price) {
        if (price % 1000 != 0) {
            OutputView.errorMessage("금액이 올바르지 않습니다.");
            throw new IllegalArgumentException();
        }
    }
}
