package lotto.vo;

public class LottoPurchaseInfo {
    private final int lottoPrice;
    private final int lottoGameCount;

    public LottoPurchaseInfo(int lottoPrice) {
        this.lottoPrice = lottoPrice;
        this.lottoGameCount = lottoPrice / 1000;
    }

    public int getLottoPrice() {
        return lottoPrice;
    }

    public int getLottoGameCount() {
        return lottoGameCount;
    }

}
