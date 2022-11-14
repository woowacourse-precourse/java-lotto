package lotto.domain.statistics;

import lotto.domain.lotto.PurchaseLottos;
import lotto.domain.lotto.WinningLotto;

public class WinningStatistics {
    private final PurchaseLottos purchaseLottos;
    private final WinningLotto winningLotto;

    private PlaceHistory placeHistory;
    private YieldRate yieldRate;

    public WinningStatistics(PurchaseLottos purchaseLottos, WinningLotto winningLotto) {
        this.purchaseLottos = purchaseLottos;
        this.winningLotto = winningLotto;

        fillLottoPlaceCount();
        setYieldRate();
    }

    // 각각 횟수 구하기
    // 수익률 구하기
    public void fillLottoPlaceCount() {
        this.placeHistory = purchaseLottos.fillPlaceHistory(winningLotto);
    }

    public void setYieldRate() {
        this.yieldRate = new YieldRate(purchaseLottos.calculateAmount(), placeHistory.amountSum());
    }

    @Override
    public String toString() {
        return String.format("당첨 통계\n---\n%s%s", placeHistory, yieldRate);
    }
}
