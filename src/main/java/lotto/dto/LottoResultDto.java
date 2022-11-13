package lotto.dto;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lotto.domain.ReceivedPrize;
import lotto.domain.lottoenum.Prize;

public class LottoResultDto {
    private final List<PrizeDto> prizes;
    private final double rateOfReturn;

    private LottoResultDto(Map<Prize, Integer> prizesCount, double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
        this.prizes = prizesCount.entrySet()
                .stream()
                .filter(prizeCount -> isNotNone(prizeCount.getKey()))
                .map(this::toPrizeDto)
                .collect(Collectors.toList());
    }

    public static LottoResultDto of(ReceivedPrize receivedPrize, double rateOfReturn) {
        return new LottoResultDto(receivedPrize.getReceivedPrize(), rateOfReturn);
    }

    public List<PrizeDto> getPrizes() {
        return prizes;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    private boolean isNotNone(Prize prize) {
        return !prize.equals(Prize.NONE);
    }

    private PrizeDto toPrizeDto(Entry<Prize, Integer> prizeCount) {
        return PrizeDto.of(prizeCount.getKey(), prizeCount.getValue());
    }

}
