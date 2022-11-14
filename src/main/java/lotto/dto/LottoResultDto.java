package lotto.dto;

import java.util.EnumMap;
import lotto.domain.LottoPrize;

public class LottoResultDto {
    private final double profitRatio;
    private final EnumMap<LottoPrize, Long> prizeCount;

    public LottoResultDto(double profitRatio, EnumMap<LottoPrize, Long> prizeCount) {
        this.profitRatio = profitRatio;
        this.prizeCount = prizeCount;
    }

    public double getProfitRatio() {
        return profitRatio;
    }

    public EnumMap<LottoPrize, Long> getPrizeCount() {
        return prizeCount;
    }
}
