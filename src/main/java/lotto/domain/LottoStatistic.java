package lotto.domain;

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

    private int computeMatchCount(Lotto lotto){
        return (int) lotto.getNumbers()
                .stream()
                .filter(winLottoNumber.getNumbers()::contains)
                .count();
    }
}
