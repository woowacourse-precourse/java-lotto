package lotto.domain;

public class Purchase {
    public static int getLottoCount(int purchaseAmount) {
        return purchaseAmount / Constant.LOTTO_PRICE;
    }
}
