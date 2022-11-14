package lotto.mvc.util.message;

import java.util.Arrays;
import lotto.util.message.LottoExceptionMessageUtils;
import lotto.mvc.util.LottoRanking;

public enum LottoRankingMessageUtils {
    RANKING_FIRST("6개 일치 %s - %s개", LottoRanking.RANKING_FIRST),
    RANKING_SECOND("5개 일치, 보너스 볼 일치 %s - %s개", LottoRanking.RANKING_SECOND),
    RANKING_THIRD("5개 일치 %s - %d개", LottoRanking.RANKING_THIRD),
    RANKING_FOURTH("4개 일치 %s - %d개", LottoRanking.RANKING_FOURTH),
    RANKING_FIFTH("3개 일치 %s - %d개", LottoRanking.RANKING_FIFTH);

    private final String message;
    private final LottoRanking lottoRanking;

    LottoRankingMessageUtils(String message, LottoRanking lottoRanking) {
        this.message = message;
        this.lottoRanking = lottoRanking;
    }

    public static String findLottoRankingMessage(LottoRanking lottoRanking, int numberOfWins) {
        return Arrays.stream(LottoRankingMessageUtils.values())
                .filter(utils -> utils.lottoRanking == lottoRanking)
                .map(utils -> String.format(utils.message, lottoRanking.findRewardMessage(), numberOfWins))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(LottoExceptionMessageUtils
                        .INVALID_RANKING.findExceptionMessage(lottoRanking.name())));
    }
}
