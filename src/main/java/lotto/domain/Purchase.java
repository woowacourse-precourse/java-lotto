package lotto.domain;

public class Purchase {
    public static int getLottoCount(int purchaseAmount) {
        checkNotDivide(purchaseAmount);
        return purchaseAmount / Constant.LOTTO_PRICE;
    }

    private static void checkNotDivide(int purchaseAmount) {
        if ((purchaseAmount % Constant.LOTTO_PRICE) != 0) {
            throw new IllegalArgumentException(Constant.NOT_DIVIDE_TEXT);
        }
    }
}
