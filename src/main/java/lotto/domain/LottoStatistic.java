package lotto.domain;

import java.util.Arrays;

public class LottoStatistic {

    public static void computeLottoRank(Lottos lottos, LottoWinNumbers winLottoNumber){
        for(Lotto lotto: lottos.getLottos()){
            LottoRank rank = getRank(computeMatchCount(lotto, winLottoNumber), hasBonusNumber(lotto, winLottoNumber.getBonus()));
            rank.addWinCount();
        }
    }

    private static LottoRank getRank(int match, boolean hasBonus){
        return Arrays.stream(LottoRank.values())
                .filter(rank -> (rank.getMatchCount() == match && hasBonus == rank.getIsBonus()))
                .findAny()
                .orElse(LottoRank.NO_PRIZE);
    }

    private static int computeMatchCount(Lotto lotto, LottoWinNumbers winLottoNumber){
        return (int) lotto.getNumbers()
                .stream()
                .filter(winLottoNumber.getNumbers()::contains)
                .count();
    }

    private static boolean hasBonusNumber(Lotto lotto, int bonus){
        return lotto.getNumbers().contains(bonus);
    }
}
