package lotto.dto.output;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.game.LottoRanking;
import lotto.domain.game.LottoResult;
import lotto.utils.message.LottoRankingMessageUtil;

public class PrintLottoResultDto {

    private final Map<LottoRanking, Integer> lottoRankingResult;
    private final BigDecimal revenuePercent;

    public PrintLottoResultDto(LottoResult lottoResult) {
        this.lottoRankingResult = lottoResult.getLottoRankingResult();
        this.revenuePercent = lottoResult.getRevenuePercent();
    }

    public List<String> getLottoRankingLog() {
        return lottoRankingResult.keySet().stream()
                .filter(lottoRanking -> lottoRanking != LottoRanking.NOTHING)
                .map(this::mapToResultMessage)
                .collect(Collectors.toList());
    }

    private String mapToResultMessage(LottoRanking lottoRanking) {
        return LottoRankingMessageUtil.findLottoRankingMessage(lottoRanking, lottoRankingResult.get(lottoRanking));
    }

    public BigDecimal getRevenuePercent() {
        return revenuePercent;
    }
}
