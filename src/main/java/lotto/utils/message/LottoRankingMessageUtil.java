package lotto.utils.message;

import java.util.Arrays;
import lotto.domain.game.LottoRanking;

public enum LottoRankingMessageUtil {
    FIRST("6개 일치 %s - %s개", LottoRanking.FIRST),
    SECOND("5개 일치, 보너스 볼 일치 %s - %s개", LottoRanking.SECOND),
    THIRD("5개 일치 %s - %d개", LottoRanking.THIRD),
    FOURTH("4개 일치 %s - %d개", LottoRanking.FOURTH),
    FIFTH("3개 일치 %s - %d개", LottoRanking.FIFTH);

    private final String message;
    private final LottoRanking lottoRanking;

    LottoRankingMessageUtil(String message, final LottoRanking lottoRanking) {
        this.message = message;
        this.lottoRanking = lottoRanking;
    }

    public static String findLottoRankingMessage(final LottoRanking lottoRanking, int numberOfWins) {
        return Arrays.stream(LottoRankingMessageUtil.values())
                .filter(utils -> utils.lottoRanking == lottoRanking)
                .map(utils -> String.format(utils.message, lottoRanking.findRewardMessage(), numberOfWins))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessageUtil.WRONG_RANKING.findFullMessage()));
    }
}
