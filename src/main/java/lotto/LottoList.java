package lotto;

import Info.PrintGameInfo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LottoList {
    public static final int AMOUNT_UNIT = 1000;

    private BigInteger lottoAmount;
    private BigInteger lottoCount;
    private List<Lotto> lottos = new ArrayList<>();

    LottoList(BigInteger amount) {
        notDivThousand(amount);

        this.lottoAmount = amount;
        this.lottoCount = lottoAmount.divide(BigInteger.valueOf(AMOUNT_UNIT));
    }

    public void notDivThousand(BigInteger amount) {
        if ("0".equals(amount.remainder(BigInteger.valueOf(AMOUNT_UNIT)))) {
            throw new IllegalArgumentException(PrintGameInfo.getNotDivThousand());
        }
    }


    public BigInteger getLottoAmount() {
        return lottoAmount;
    }
    public BigInteger getLottoCount() {
        return lottoCount;
    }

    /**
     * 전체 로또 발행 함수
     */
    public void setAllLottoList() {

    }
}

