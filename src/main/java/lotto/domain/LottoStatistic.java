package lotto.domain;

import java.util.Arrays;

public class LottoStatistic {
    private Lottos lottos;
    private LottoWinNumbers winLottoNumber;
    public LottoStatistic(Lottos lottos, LottoWinNumbers winLottoNumber){
        setStatistic(lottos, winLottoNumber);
    }

    public void setStatistic(Lottos lottos, LottoWinNumbers winLottoNumber){
        this.lottos = lottos;
        this.winLottoNumber = winLottoNumber;
    }

    public void computeLottoRank(){
        for(Lotto lotto: lottos.getLottos()){
            LottoRank rank = getRank(computeMatchCount(lotto), hasBonusNumber(lotto));
            rank.addWinCount();
        }
    }

    private LottoRank getRank(int match, boolean hasBonus){
        return Arrays.stream(LottoRank.values())
                .filter(rank -> (rank.getMatchCount() == match && hasBonus == rank.getIsBonus()))
                .findAny()
                .orElse(LottoRank.NO_PRIZE);
    }

    private int computeMatchCount(Lotto lotto){
        return (int) lotto.getNumbers()
                .stream()
                .filter(winLottoNumber.getNumbers()::contains)
                .count();
    }

    private boolean hasBonusNumber(Lotto lotto){
        return lotto.getNumbers().contains(winLottoNumber.getBonus());
    }
}
