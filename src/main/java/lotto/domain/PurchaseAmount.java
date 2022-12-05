package lotto.domain;

import lotto.view.InputView;

public class PurchaseAmount {

    private static int purchaseAmount;

    public static void validate(int purchaseAmount1) {
        purchaseAmount=purchaseAmount1;
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("구입금액은 음수가 아닙니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("구입금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    public int getNumberOfLotto() {
        return purchaseAmount / 1000;
    }

    public float calculateRate(int sum) {
        return sum / (float) purchaseAmount * 100;
    }
}
