package lotto.domain;

import java.util.Arrays;
import lotto.domain.MatchConst.*;

public enum LottoMatch {

    SIX_MATCHES(MatchCount.SIX_MATCH, MatchProfit.SIX_MATCH_PROFIT, MatchMessage.SIX_MATCHES_MSG),
    FIVE_MATCHES_PLUS_BONUS(MatchCount.FIVE_MATCH_PLUS_BONUS, MatchProfit.FIVE_MATCH_PLUS_BONUS_PROFIT,
            MatchMessage.FIVE_MATCHES_PLUS_BONUS_MSG),
    FIVE_MATCHES(MatchCount.FIVE_MATCH, MatchProfit.FIVE_MATCH_PROFIT, MatchMessage.FIVE_MATCHES_MSG),
    FOUR_MATCHES(MatchCount.FOUR_MATCH, MatchProfit.FOUR_MATCH_PROFIT, MatchMessage.FOUR_MATCHES_MSG),
    THREE_MATCHES(MatchCount.THREE_MATCH, MatchProfit.THREE_MATCH_PROFIT, MatchMessage.THREE_MATCHES_MSG),
    NULL_RESULT(-1, -1, null);

    private final int matchCount;
    private final int matchProfit;
    private final String matchMsg;

    LottoMatch(int matchCount, int matchProfit, String matchMsg) {
        this.matchCount = matchCount;
        this.matchProfit = matchProfit;
        this.matchMsg = matchMsg;
    }

    // 연산된 로또 결과와 enum mapping 해서 일치하는 enum 반환
    public static LottoMatch calculatedLottoMapper(CalculatedLotto calculatedLotto) {
        return Arrays.stream(LottoMatch.values())
                .filter(lottoMatch -> lottoMatch.matches(calculatedLotto))
                .findAny()
                .orElse(NULL_RESULT);
    }

    // 일치 여부 반환
    public boolean matches(CalculatedLotto calculatedLotto) {
        if (calculatedLotto.getWinningLottoCount() == 5 && matchCount == 5 && calculatedLotto
                .isBonusNumberIncluded()) {
            return true;
        }
        if (calculatedLotto.getWinningLottoCount() == matchCount) {
            return true;
        }
        return false;
    }

    public int getProfit() {
        return matchProfit;
    }

    public String getResultMsg() {
        return matchMsg;
    }
}
