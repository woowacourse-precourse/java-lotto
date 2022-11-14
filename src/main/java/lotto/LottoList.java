package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoList {
    public static final int AMOUNT_UNIT = 1000;

    private Long lottoAmount;
    private Long lottoCount;


    private List<Lotto> lottos = new ArrayList<>();

    LottoList(Long amount) {
        this.lottoAmount = amount;
        this.lottoCount = lottoAmount / AMOUNT_UNIT;
    }

    public Long getLottoAmount() {
        return lottoAmount;
    }
    public Long getLottoCount() {
        return lottoCount;
    }

}
