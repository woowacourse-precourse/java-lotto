package lotto.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import lotto.type.LottoStandard;

public class LottoStatistic {

    private final Map<LottoStandard, Integer> resultMap;
    private BigDecimal yield;
    private static final int DECIMAL_POINT = 1;

    public LottoStatistic() {
        resultMap = new HashMap<>();
        for (LottoStandard lottoStandard : LottoStandard.values()) {
            resultMap.put(lottoStandard, 0);
        }
    }

    public Map<LottoStandard, Integer> getResultMap() {
        return resultMap;
    }

    public BigDecimal getYield() {
        return yield;
    }

    public void addLottoStandard(final LottoStandard lottoStandard) {
        resultMap.replace(lottoStandard, resultMap.get(lottoStandard) + 1);
    }

    public void calculateYield(final long purchaseAmount, final long totalPrize) {
        this.yield = BigDecimal.valueOf(totalPrize)
            .multiply(BigDecimal.valueOf(100L))
            .divide(BigDecimal.valueOf(purchaseAmount), DECIMAL_POINT, RoundingMode.HALF_UP);
    }
}
