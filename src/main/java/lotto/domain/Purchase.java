package lotto.domain;

public class Purchase {
    public static int getLottoCount(int purchaseAmount) {
        checkNotDivide(purchaseAmount);
        return purchaseAmount / Constant.LOTTO_PRICE;
    }

    private static void checkNotDivide(int purchaseAmount) {
        if ((purchaseAmount % Constant.LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }
}
