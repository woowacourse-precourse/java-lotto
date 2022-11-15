package lotto;

public class LottoCount {
    private static final String VALID_LOTTO_MINUS_MESSAGE = "[ERROR] 로또 갯수가 마이너스 입니다.";
    private int lottoCount;

    public LottoCount(int lottoCount) {
        validLottoMinusCount(lottoCount);
        this.lottoCount = lottoCount;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    private void validLottoMinusCount(int lottoCount) {
        if (lottoCount < 0){
            throw new IllegalArgumentException(VALID_LOTTO_MINUS_MESSAGE);
        }
    }
}
