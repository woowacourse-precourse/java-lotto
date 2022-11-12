package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import lotto.util.message.LottoRankingMessageUtils;
import lotto.util.ranking.LottoRanking;

public class LottoResult {

    private static final int GRADE_PLUS_VALUE = 1;
    private static final String MESSAGE_PREFIX = "당첨 통계\n---\n";
    private static final String LINE_FEED = "\n";

    private final Map<LottoRanking, Integer> lottoRankingResult = new EnumMap<>(LottoRanking.class);

    public void addRankingCount(LottoRanking lottoRanking) {
        lottoRankingResult.put(lottoRanking, lottoRankingResult.getOrDefault(lottoRanking, 0) + GRADE_PLUS_VALUE);
    }

    public BigDecimal calculateTotalReward() {
        return lottoRankingResult.keySet()
                .stream()
                .filter(lottoRanking -> lottoRanking != LottoRanking.RANKING_NOTHING)
                .map(this::calculateTargetLottoRankingTotalReward)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateTargetLottoRankingTotalReward(LottoRanking target) {
        return target.calculateTotalTargetLottoRankingReward(lottoRankingResult.get(target));
    }

    @Override
    public String toString() {
        StringBuilder lottoResultMessage = new StringBuilder();

        lottoResultMessage.append(MESSAGE_PREFIX);

        Arrays.stream(LottoRanking.values())
                .filter(lottoRanking -> lottoRanking != LottoRanking.RANKING_NOTHING)
                .forEach(lottoRanking ->
                        lottoResultMessage
                                .append(processLottoRankingResultMessage(lottoRanking))
                                .append(LINE_FEED));
        return lottoResultMessage.toString();
    }

    private String processLottoRankingResultMessage(LottoRanking lottoRanking) {
        return LottoRankingMessageUtils
                .findLottoRankingMessage(lottoRanking, lottoRankingResult.getOrDefault(lottoRanking, 0));
    }
}
