package lotto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LottoList {
    public static final int AMOUNT_UNIT = 1000;

    private BigInteger lottoAmount;
    private BigInteger lottoCount;


    private List<Lotto> lottos = new ArrayList<>();

    LottoList(BigInteger amount) {
        this.lottoAmount = amount;
        this.lottoCount = lottoAmount.divide(BigInteger.valueOf(AMOUNT_UNIT));
    }

    public BigInteger getLottoAmount() {
        return lottoAmount;
    }
    public BigInteger getLottoCount() {
        return lottoCount;
    }

}
