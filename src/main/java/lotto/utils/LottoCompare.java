package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import lotto.domain.LottoOrder;
import lotto.domain.LottoRank;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoCompare {
    /**
     * 구입한 로또 하나와 당첨/보너스 번호를 비교해 등수 반환
     *
     * @param lotto       구입한 로또 하나
     * @param lottoAnswer 당첨/보너스 번호
     * @return 당첨 등수 반환 (없을 경우 null 반환)
     */
    public static LottoRank compareOneTicket(Lotto lotto, LottoAnswer lottoAnswer) {
        int correctCount = lottoAnswer.getCorrectCount(lotto);
        boolean containBonus = lottoAnswer.isContainBonus(lotto);

        for (LottoRank lottoRank : LottoRank.getSortedValues()) {
            if (correctCount == lottoRank.CORRECT_COUNT_CONDITION
                    && (!lottoRank.IS_BONUS_NEEDED || containBonus)) {
                return lottoRank;
            }
        }

        return null;
    }

    /**
     * 구입한 모든 로또와 당첨/보너스 번호를 비교해 각 등수별 당첨 횟수 반환
     *
     * @param lottoOrder  구입한 로또들
     * @param lottoAnswer 당첨/보너스 번호
     * @return 각 등수별 당첨 횟수
     */
    public static Map<LottoRank, Integer> compareAllTickets(LottoOrder lottoOrder, LottoAnswer lottoAnswer) {
        Map<LottoRank, Integer> totalRank = new LinkedHashMap<>();

        for (LottoRank lottoRank : LottoRank.values()) {
            totalRank.put(lottoRank, 0);
        }
        for (Lotto lotto : lottoOrder.getLottoTickets()) {
            LottoRank lottoRank = compareOneTicket(lotto, lottoAnswer);
            if (lottoRank != null) {
                totalRank.put(lottoRank, totalRank.get(lottoRank) + 1);
            }
        }

        return totalRank;
    }
}
