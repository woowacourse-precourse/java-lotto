package lotto;

public class LottoGame {
    private static final int ONE_LOTTO_PRICE = 1000;

    public void getLottoPrice() {
        int lottoPrice = InputView.getLottoPrice();
        int lottoCount = getLottoCount(lottoPrice);
    }

    private int getLottoCount(int lottoPrice) {
        return lottoPrice / ONE_LOTTO_PRICE;
    }
}
