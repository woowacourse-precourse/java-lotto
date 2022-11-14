package lotto.mvc.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.number.Lotto;
import lotto.domain.number.LottoNumber;
import lotto.domain.player.Player;
import lotto.util.message.CommonMessageConst;
import lotto.mvc.util.message.LottoRankingMessageUtils;
import lotto.mvc.util.LottoRanking;

public class LottoResult {

    private static final int GRADE_PLUS_VALUE = 1;
    private static final String LOTTO_RESULT_MESSAGE_PREFIX = "당첨 통계";
    private static final String LOTTO_RESULT_MESSAGE_CONTOUR = "---";
    private static final String REVENUE_PERCENT_MESSAGE_FORMAT = "총 수익률은 %s%%입니다.";

    private final Map<LottoRanking, Integer> lottoRankingResult = new EnumMap<>(LottoRanking.class);
    private final BigDecimal revenuePercent;

    public LottoResult(Player player, Lotto winningLotto, LottoNumber bonusNumber) {
        List<LottoRanking> lottoRankings = player.calculateLottoRanking(winningLotto, bonusNumber);

        addRankingCount(lottoRankings);
        BigDecimal totalReward = calculateTotalReward();
        revenuePercent = player.calculateRevenuePercent(totalReward);
    }

    private void addRankingCount(List<LottoRanking> lottoRankings) {
        lottoRankings.forEach(
                ranking ->
                        lottoRankingResult.put(ranking,
                                lottoRankingResult.getOrDefault(ranking, 0) + GRADE_PLUS_VALUE));
    }

    private BigDecimal calculateTotalReward() {
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
        StringBuilder lottoResultMessage = new StringBuilder(CommonMessageConst.LINE_FEED);

        lottoResultMessage.append(LOTTO_RESULT_MESSAGE_PREFIX)
                .append(CommonMessageConst.LINE_FEED)
                .append(LOTTO_RESULT_MESSAGE_CONTOUR)
                .append(CommonMessageConst.LINE_FEED);

        String lottoRankingMessage = processLottoRankingMessage();
        lottoResultMessage.append(lottoRankingMessage).append(CommonMessageConst.LINE_FEED);

        String revenuePercentMessage = String.format(REVENUE_PERCENT_MESSAGE_FORMAT, revenuePercent.toString());
        lottoResultMessage.append(revenuePercentMessage);

        return lottoResultMessage.toString();
    }

    private String processLottoRankingMessage() {
        return Arrays.stream(LottoRanking.values())
                .filter(lottoRanking -> lottoRanking != LottoRanking.RANKING_NOTHING)
                .map(this::processLottoRankingResultMessage)
                .collect(Collectors.joining(CommonMessageConst.LINE_FEED));
    }

    private String processLottoRankingResultMessage(LottoRanking lottoRanking) {
        return LottoRankingMessageUtils
                .findLottoRankingMessage(lottoRanking, lottoRankingResult.getOrDefault(lottoRanking, 0));
    }
}
