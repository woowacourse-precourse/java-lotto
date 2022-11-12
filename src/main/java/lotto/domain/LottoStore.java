package lotto.domain;

import java.math.BigDecimal;

public class LottoStore {

    private final Player player;
    private Lotto winningLotto;

    public LottoStore(LottoPurchaseAmount lottoPurchaseAmount) {
        this.player = new Player(lottoPurchaseAmount);
    }

    public void createWinningLotto(String winningNumbers) {
        winningLotto = new Lotto(winningNumbers);
    }

    public LottoResult calculateLottoResult(LottoNumber bonusNumber) {
        LottoResult lottoResult = new LottoResult();

        player.calculateLottoRanking(lottoResult, winningLotto, bonusNumber);
        return lottoResult;
    }

    public BigDecimal calculateRevenuePercent(LottoResult lottoResult) {
        return player.calculateRevenuePercent(lottoResult.calculateTotalReward());
    }
}
