package lotto.dto.output;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.game.LottoRanking;
import lotto.utils.message.LottoRankingMessageUtil;

public class PrintLottoResultDto {

    private final Map<LottoRanking, Integer> lottoRankingResult;

    public PrintLottoResultDto(Map<LottoRanking, Integer> lottoRankingResult) {
        this.lottoRankingResult = lottoRankingResult;
    }

    public List<String> getLottoRankingLog() {
        return lottoRankingResult.keySet().stream()
                .filter(lottoRanking -> lottoRanking != LottoRanking.NOTHING)
                .map(this::mapToResultLog)
                .collect(Collectors.toList());
    }

    private String mapToResultLog(LottoRanking lottoRanking) {
        return LottoRankingMessageUtil.findLottoRankingMessage(lottoRanking, lottoRankingResult.get(lottoRanking));
    }
}
