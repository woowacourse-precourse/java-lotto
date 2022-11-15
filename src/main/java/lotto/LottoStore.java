package lotto;

public class LottoStore {
    private final int lottoPrice = 1000;

    public int calculatePurchasedLottoCount(int inputMoney) {
        int lottoCount = inputMoney / lottoPrice;
        return lottoCount;
    }
}
